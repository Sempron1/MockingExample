package com.example.controller;


import com.example.dao.EmployeeRepository;
import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeController {
    @Autowired
    public EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public String saveEmployee(Employee employee){
        employeeRepository.save(employee);
        return "Employee saved";
    }

    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

}
