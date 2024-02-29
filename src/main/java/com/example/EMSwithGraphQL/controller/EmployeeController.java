package com.example.EMSwithGraphQL.controller;

import com.example.EMSwithGraphQL.model.Employee;
import com.example.EMSwithGraphQL.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {
    public EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService _employeeService) {
        employeeService = _employeeService;
    }

    @QueryMapping
    public List<Employee> employee(String empName) {
        return employeeService.getEmployees();
    }
}