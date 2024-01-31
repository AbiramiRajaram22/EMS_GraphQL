package com.example.EMSwithGraphQL.controller;


import com.example.EMSwithGraphQL.model.Employee;
import com.example.EMSwithGraphQL.model.Skills;
import com.example.EMSwithGraphQL.service.EmployeeService;
import com.example.EMSwithGraphQL.service.ProjectService;
import com.example.EMSwithGraphQL.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeController {
    public EmployeeService employeeService;
    public SkillService skillService;
    public ProjectService projectService;

    @Autowired
    public EmployeeController(EmployeeService _employeeService, SkillService _skillService, ProjectService _projectService) {
        employeeService = _employeeService;
        skillService = _skillService;
        projectService = _projectService;
    }

    @QueryMapping
    public List<Employee> employees() {
        return employeeService.getEmployees();
    }
    @QueryMapping
    public Employee employee(@Argument String empName) {
        return employeeService.getEmployeeDetailsByEmpName(empName);
    }
    @QueryMapping
    public Employee fetchEmployeeProjects(@Argument String empName) {
       return employeeService.getProjectExperience(empName);
    }
    @MutationMapping
    public String createSkill(@Argument String skillName, @Argument List<String> projects) {
        Skills skill = skillService.createSkills(skillName,projects);
        if(skill != null) {
            return "Skill added successfully";
        }
        else {
            return "Something went wrong";
        }
    }
    @QueryMapping
    public List<Skills> skills() {
        return skillService.getSkills();
    }
}