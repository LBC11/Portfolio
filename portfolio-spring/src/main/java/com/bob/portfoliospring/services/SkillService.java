package com.bob.portfoliospring.services;

import com.bob.portfoliospring.entities.SkillCategory;
import com.bob.portfoliospring.entities.Skill;
import com.bob.portfoliospring.repository.SkillCategoryRepository;
import com.bob.portfoliospring.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;
    
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Skill getSkillById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    public Skill saveOrUpdateSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

    public Skill saveSkillWithSkillCategory(Long skillCategoryId, Skill skill) {
        Optional<SkillCategory> SkillCategoryOptional = skillCategoryRepository.findById(skillCategoryId);
        if (SkillCategoryOptional.isPresent()) {
            SkillCategory SkillCategory = SkillCategoryOptional.get();
            skill.setSkillCategory(SkillCategory);
            return skillRepository.save(skill);
        }
        return null;
    }
}
