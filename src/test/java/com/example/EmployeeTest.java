package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    Employee employee = new Employee("1", 20);

    @Test
    void constructorSetCorrectValues() {

        assertEquals("1",employee.getId());
    }

}