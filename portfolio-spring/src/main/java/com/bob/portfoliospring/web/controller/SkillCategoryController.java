package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.SkillCategory;
import com.bob.portfoliospring.web.dto.SkillCategoryDTO;
import com.bob.portfoliospring.web.service.SkillCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "SkillCategory")
@RestController
@RequestMapping("/api/skill-category")
public class SkillCategoryController {

    @Autowired
    private SkillCategoryService skillCategoryService;

    @ApiOperation(value = "Get all skill categories")
    @GetMapping("/")
    public List<SkillCategoryDTO> getAllSkillCategories() {
        return skillCategoryService.getAllSkillCategories();
    }

    @ApiOperation(value = "Get skill category by ID")
    @GetMapping("/{id}")
    public SkillCategoryDTO getSkillCategoryById(@PathVariable Long id) {
        return skillCategoryService.getSkillCategoryById(id);
    }

    @ApiOperation(value = "Save or update skill category")
    @PostMapping("/")
    public SkillCategoryDTO saveOrUpdateSkillCategory(@RequestParam Long skillsAndTechniquesId, @RequestBody SkillCategory skillCategory) {
        return skillCategoryService.saveSkillCategoryWithSkillsAndTechniques(skillsAndTechniquesId, skillCategory);
    }

    @ApiOperation(value = "Delete skill category by ID")
    @DeleteMapping("/{id}")
    public void deleteSkillCategory(@PathVariable Long id) {
        skillCategoryService.deleteSkillCategory(id);
    }
}
