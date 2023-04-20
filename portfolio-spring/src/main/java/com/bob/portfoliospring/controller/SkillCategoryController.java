package com.bob.portfoliospring.controller;

import com.bob.portfoliospring.entities.SkillCategory;
import com.bob.portfoliospring.services.SkillCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill-category")
public class SkillCategoryController {

    @Autowired
    private SkillCategoryService skillCategoryService;

    @GetMapping("/")
    public List<SkillCategory> getAllSkillCategories() {
        return skillCategoryService.getAllSkillCategories();
    }

    @GetMapping("/{id}")
    public SkillCategory getSkillCategoryById(@PathVariable Long id) {
        return skillCategoryService.getSkillCategoryById(id);
    }

    @PostMapping("/")
    public SkillCategory saveOrUpdateSkillCategory(@RequestBody SkillCategory skillCategory) {
        return skillCategoryService.saveOrUpdateSkillCategory(skillCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteSkillCategory(@PathVariable Long id) {
        skillCategoryService.deleteSkillCategory(id);
    }
}
