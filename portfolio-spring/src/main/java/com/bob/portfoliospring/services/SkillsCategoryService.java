package com.bob.portfoliospring.services;

import com.bob.portfoliospring.entities.SkillCategory;
import com.bob.portfoliospring.repository.SkillCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillsCategoryService {

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;

    public List<SkillCategory> getAllSkillCategories() {
        return skillCategoryRepository.findAll();
    }

    public SkillCategory getSkillCategoryById(Long id) {
        return skillCategoryRepository.findById(id).orElse(null);
    }

    public SkillCategory saveOrUpdateSkillCategory(SkillCategory skillCategory) {
        return skillCategoryRepository.save(skillCategory);
    }

    public void deleteCategoryById(Long id) {
        skillCategoryRepository.deleteById(id);
    }
}
