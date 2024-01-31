package com.example.EMSwithGraphQL.service;

import com.example.EMSwithGraphQL.model.Project;
import com.example.EMSwithGraphQL.model.Skills;
import com.example.EMSwithGraphQL.repository.EmployeeRepository;
import com.example.EMSwithGraphQL.repository.ProjectRepository;
import com.example.EMSwithGraphQL.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    public EmployeeRepository employeeRepository;
    public ProjectRepository projectRepository;

    @Autowired
    public ProjectService(EmployeeRepository _employeeRepository, ProjectRepository _projectRepository) {
        employeeRepository = _employeeRepository;
        projectRepository = _projectRepository;
    }
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project createProject(String projectName) {
        Project project = new Project();
        project.name = projectName;
        if(!checkIfProjectAlreadyExists(projectName)) {
            projectRepository.save(project);
        }
        return project;
    }

    public boolean checkIfProjectAlreadyExists(String projectName)
    {
        boolean isProjectExists = false;
        List<Project> exisitingProjects = projectRepository.findAll();
        isProjectExists = exisitingProjects.stream()
                .map(project -> project.name)
                .toList().contains(projectName);
        return isProjectExists;
    }
}
