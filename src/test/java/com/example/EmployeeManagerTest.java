package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeManagerTest {


    @Test
    void payEmployeesReturnTrueWhenASuccessfulPaymentIsCompleted() {
        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        BankService bankService = mock(BankService.class);

        List<Employee> employees = List.of(new Employee("1",20));
        when(employeeRepository.findAll()).thenReturn(employees);
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository,bankService);
        employeeManager.payEmployees();

        assertTrue(employees.get(0).isPaid());
    }

    @Test
    void isPaidShouldBeFalseIfPaymentFails() {
        EmployeeRepository employeeRepositoryDummy = new EmployeeRepositoryDummy();
        BankService bankServiceDummy = new BankServiceDummy();
        EmployeeManager employeeManager = new EmployeeManager(employeeRepositoryDummy,bankServiceDummy );
        employeeManager.payEmployees();
        assertFalse(employeeRepositoryDummy.findAll().get(0).isPaid());
    }

    @Test
    void payEmployeesShouldReturnCorrectAmountOfPaymentsMade() {

        EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
        BankService bankService = mock(BankService.class);

        List<Employee> employees = List.of(new Employee("1",10), new Employee("2",20), new Employee("3",30));
        when(employeeRepository.findAll()).thenReturn(employees);
        EmployeeManager employeeManager = new EmployeeManager(employeeRepository,bankService);
        employeeManager.payEmployees();

        assertEquals(3, employeeManager.payEmployees());

    }
    

}