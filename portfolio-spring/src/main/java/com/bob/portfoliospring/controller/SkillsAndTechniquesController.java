package com.bob.portfoliospring.controller;

import com.bob.portfoliospring.entities.SkillsAndTechniques;
import com.bob.portfoliospring.services.SkillsAndTechniquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills-and-technique")
public class SkillsAndTechniquesController {

    @Autowired
    private SkillsAndTechniquesService SkillsAndTechniquesService;

    @GetMapping("/")
    public List<SkillsAndTechniques> getAllSkillsAndTechniques() {
        return SkillsAndTechniquesService.getAllSkillsAndTechniques();
    }

    @GetMapping("/{id}")
    public SkillsAndTechniques getSkillsAndTechniquesById(@PathVariable Long id) {
        return SkillsAndTechniquesService.getSkillsAndTechniquesById(id);
    }

    @PostMapping("/")
    public SkillsAndTechniques saveOrUpdateSkillsAndTechniques(@RequestParam Long personalInformationId, @RequestBody SkillsAndTechniques SkillsAndTechniques) {
        return SkillsAndTechniquesService.saveSkillsAndTechniquesWithPersonalInformation(personalInformationId, SkillsAndTechniques);
    }

    @DeleteMapping("/{id}")
    public void deleteSkillsAndTechniques(@PathVariable Long id) {
        SkillsAndTechniquesService.deleteSkillsAndTechniques(id);
    }
}
