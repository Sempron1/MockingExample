package com.example;

import com.example.model.Employee;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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

    @Test
    void toStringMethodReturnsCorrectString() {

        var value = "Employee [id=" + employee.getId() + ", salary=" + employee.getSalary() + "]";

        assertEquals(value, employee.toString());

    }

}