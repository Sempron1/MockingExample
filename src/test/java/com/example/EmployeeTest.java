package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee employee = new Employee("1", 20);

    @Test
    void constructorSetCorrectValues() {

        assertEquals("1",employee.getId());
    }

    @Test
    void setSalaryAndGetSalaryWorksCorrectly() {

        employee.setSalary(10);
        assertEquals(10,employee.getSalary());
    }

    @Test
    void setIdAndGetIdWorksCorrectly() {

        employee.setId("2");
        assertEquals("2",employee.getId());

    }

    @Test
    void setPaidAndGetPaidWorksCorrectly() {
        employee.setPaid(true);
        assertTrue(employee.isPaid());
    }

}