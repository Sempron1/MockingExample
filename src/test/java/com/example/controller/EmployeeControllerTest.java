package com.example.controller;

import com.example.dao.EmployeeRepository;
import com.example.dao.EmployeeRepositoryTest;
import com.example.model.Employee;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeControllerTest {

    @Test
    void ableToSaveANewEmployeeToTheEmployeeRepository() {
        Employee employee1 = new Employee("1",20);
        EmployeeRepositoryTest employeeRepositoryTest = new EmployeeRepositoryTest();
        EmployeeController employeeController = new EmployeeController(employeeRepositoryTest);
        employeeController.saveEmployee(employee1);
        assertEquals(1,employeeController.getAll().size());
    }
    @Test
    void getAllPrintsOutAllEmployeesInTheList() {
        Employee employee1 = new Employee("1",20);
        EmployeeRepositoryTest employeeRepositoryTest = new EmployeeRepositoryTest();
        EmployeeController employeeController = new EmployeeController(employeeRepositoryTest);
        employeeController.saveEmployee(employee1);

        assertEquals(employeeController.getAll(),employeeController.getAll());
    }





}