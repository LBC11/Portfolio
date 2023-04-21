package com.bob.portfoliospring.controller;

import com.bob.portfoliospring.entities.Skill;
import com.bob.portfoliospring.services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/")
    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }

    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }

    @PostMapping("/")
    public Skill saveOrUpdateSkill(@RequestParam Long skillCategoryId, @RequestBody Skill skill) {
        return skillService.saveSkillWithSkillCategory(skillCategoryId, skill);
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
    }

}
