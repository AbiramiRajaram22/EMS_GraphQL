package com.example.EMSwithGraphQL.service;

import com.example.EMSwithGraphQL.model.Employee;
import com.example.EMSwithGraphQL.model.Project;
import com.example.EMSwithGraphQL.model.Skills;
import com.example.EMSwithGraphQL.repository.EmployeeRepository;
import com.example.EMSwithGraphQL.repository.ProjectRepository;
import com.example.EMSwithGraphQL.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    public EmployeeRepository employeeRepository;
    public ProjectRepository projectRepository;
    public SkillRepository skillRepository;

    @Autowired
    public EmployeeService(EmployeeRepository _employeeRepository, ProjectRepository _projectRepository, SkillRepository _skillRepository) {
        employeeRepository = _employeeRepository;
        projectRepository = _projectRepository;
        skillRepository = _skillRepository;
    }
    public List<Employee> getEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        for (Employee e:
                employees) {
            e = getProjectExperience(e.empName);
        }
        return employees;
    }
    public Employee getEmployeeDetailsByEmpName(String name)
    {
        return getProjectExperience(name);
    }

    public Employee getProjectExperience(String name) {
        Employee data = employeeRepository.fetchEmployee(name);
        data.tnfProjects = getProjectDetailsByClient(data.elementId,"TNF");
        data.mheProjects = getProjectDetailsByClient(data.elementId,"MHE");
        return data;
    }

    private List<Project> getProjectDetailsByClient(long employeeId, String clientName) {
        List<Project> projects = projectRepository.fetchEmployeeProjects(employeeId, clientName);
        for (Project p:
                projects) {
            p.skills = skillRepository.fetchSkillsByProject(employeeId, p.elementId);
        }
        return projects;
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }
}
