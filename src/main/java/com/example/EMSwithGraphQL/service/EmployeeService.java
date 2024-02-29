package com.example.EMSwithGraphQL.service;

import com.example.EMSwithGraphQL.model.Employee;
import com.example.EMSwithGraphQL.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    public EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository _employeeRepository) {
        employeeRepository = _employeeRepository;
    }
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
//    public UserDetails getEmployee(String empName) {
//
//        Employee employee= employeeRepository.fetchEmployee(empName);
//        if (employee == null) {
//            throw new UsernameNotFoundException("User not found: " + empName);
//        }
//        return new org.springframework.security.core.userdetails.User(
//                employee.empName,
//                employee.empId,
//                new ArrayList<>()
//        );
//    }

}
