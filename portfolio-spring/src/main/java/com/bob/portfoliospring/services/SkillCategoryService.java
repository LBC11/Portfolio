package com.bob.portfoliospring.services;

import com.bob.portfoliospring.entities.SkillsAndTechniques;
import com.bob.portfoliospring.entities.SkillCategory;
import com.bob.portfoliospring.entities.SkillCategory;
import com.bob.portfoliospring.repository.SkillCategoryRepository;
import com.bob.portfoliospring.repository.SkillCategoryRepository;
import com.bob.portfoliospring.repository.SkillsAndTechniquesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillCategoryService {

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;
    @Autowired
    private SkillsAndTechniquesRepository skillsAndTechniquesRepository;

    public List<SkillCategory> getAllSkillCategories() {
        return skillCategoryRepository.findAll();
    }

    public SkillCategory getSkillCategoryById(Long id) {
        return skillCategoryRepository.findById(id).orElse(null);
    }

    public SkillCategory saveOrUpdateSkillCategory(SkillCategory skillCategory) {
        return skillCategoryRepository.save(skillCategory);
    }

    public void deleteSkillCategory(Long id) {
        skillCategoryRepository.deleteById(id);
    }

    public SkillCategory saveSkillCategoryWithSkillsAndTechniques(Long skillsAndTechniquesId, SkillCategory skillCategory) {
        Optional<SkillsAndTechniques> SkillsAndTechniquesOptional = skillsAndTechniquesRepository.findById(skillsAndTechniquesId);
        if (SkillsAndTechniquesOptional.isPresent()) {
            SkillsAndTechniques SkillsAndTechniques = SkillsAndTechniquesOptional.get();
            skillCategory.setSkillsAndTechniques(SkillsAndTechniques);
            return skillCategoryRepository.save(skillCategory);
        }
        return null;
    }
}
