package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.Skill;
import com.bob.portfoliospring.web.dto.SkillDTO;
import com.bob.portfoliospring.web.service.SkillService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Skill")
@RestController
@RequestMapping("/api/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @ApiOperation(value = "Get all skills")
    @GetMapping("/")
    public List<SkillDTO> getAllSkills() {
        return skillService.getAllSkills();
    }

    @ApiOperation(value = "Get skill by ID")
    @GetMapping("/{id}")
    public SkillDTO getSkillById(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }

    @ApiOperation(value = "Save or update skill")
    @PostMapping("/")
    public SkillDTO saveOrUpdateSkill(@RequestParam Long skillCategoryId, @RequestBody Skill skill) {
        return skillService.saveSkillWithSkillCategory(skillCategoryId, skill);
    }

    @ApiOperation(value = "Delete skill by ID")
    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
    }

}
