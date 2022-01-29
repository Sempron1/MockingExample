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
    void setSalaryAndGetSalaryShouldReturnExpectedValues() {

        employee.setSalary(10);
        assertEquals(10,employee.getSalary());
    }

    @Test
    void setIdAndGetIdShouldReturnExpectedValues() {

        employee.setId("2");
        assertEquals("2",employee.getId());

    }

    @Test
    void setPaidAndGetPaidShouldReturnExpectedValues() {
        employee.setPaid(true);
        assertTrue(employee.isPaid());
    }

    @Test
    void toStringMethodShouldReturnCorrectString() {

        var value = "Employee [id=" + employee.getId() + ", salary=" + employee.getSalary() + "]";

        assertEquals(value, employee.toString());

    }

}