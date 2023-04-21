package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.SkillCategory;
import com.bob.portfoliospring.web.dto.SkillCategoryDTO;
import com.bob.portfoliospring.web.service.SkillCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill-category")
public class SkillCategoryController {

    @Autowired
    private SkillCategoryService skillCategoryService;

    @GetMapping("/")
    public List<SkillCategoryDTO> getAllSkillCategories() {
        return skillCategoryService.getAllSkillCategories();
    }

    @GetMapping("/{id}")
    public SkillCategoryDTO getSkillCategoryById(@PathVariable Long id) {
        return skillCategoryService.getSkillCategoryById(id);
    }

    @PostMapping("/")
    public SkillCategoryDTO saveOrUpdateSkillCategory(@RequestParam Long skillsAndTechniquesId, @RequestBody SkillCategory skillCategory) {
        return skillCategoryService.saveSkillCategoryWithSkillsAndTechniques(skillsAndTechniquesId, skillCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteSkillCategory(@PathVariable Long id) {
        skillCategoryService.deleteSkillCategory(id);
    }
}
