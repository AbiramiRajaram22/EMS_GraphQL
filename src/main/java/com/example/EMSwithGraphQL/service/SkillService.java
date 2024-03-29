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
public class SkillService {
    public SkillRepository skillRepository;
    @Autowired
    public SkillService(SkillRepository _skillRepository) {
        skillRepository = _skillRepository;
    }
    public List<Skills> getSkills() {
        return skillRepository.findAll();
    }

    public Skills createSkills(String skillName, List<String> projects) {
        Skills skill = new Skills();
        skill.skillName = skillName;
        skillRepository.save(skill);
        return skill;
    }
}
