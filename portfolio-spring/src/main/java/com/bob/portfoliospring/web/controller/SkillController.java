package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.Skill;
import com.bob.portfoliospring.web.dto.SkillDTO;
import com.bob.portfoliospring.web.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/")
    public List<SkillDTO> getAllSkills() {
        return skillService.getAllSkills();
    }

    @GetMapping("/{id}")
    public SkillDTO getSkillById(@PathVariable Long id) {
        return skillService.getSkillById(id);
    }

    @PostMapping("/")
    public SkillDTO saveOrUpdateSkill(@RequestParam Long skillCategoryId, @RequestBody Skill skill) {
        return skillService.saveSkillWithSkillCategory(skillCategoryId, skill);
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
    }

}
