package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.SkillsAndTechniques;
import com.bob.portfoliospring.web.dto.SkillsAndTechniquesDTO;
import com.bob.portfoliospring.web.service.SkillsAndTechniquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills-and-technique")
public class SkillsAndTechniquesController {

    @Autowired
    private SkillsAndTechniquesService SkillsAndTechniquesService;

    @GetMapping("/")
    public List<SkillsAndTechniquesDTO> getAllSkillsAndTechniques() {
        return SkillsAndTechniquesService.getAllSkillsAndTechniques();
    }

    @GetMapping("/{id}")
    public SkillsAndTechniquesDTO getSkillsAndTechniquesById(@PathVariable Long id) {
        return SkillsAndTechniquesService.getSkillsAndTechniquesById(id);
    }

    @PostMapping("/")
    public SkillsAndTechniquesDTO saveOrUpdateSkillsAndTechniques(@RequestParam Long personalInformationId, @RequestBody SkillsAndTechniques SkillsAndTechniques) {
        return SkillsAndTechniquesService.saveSkillsAndTechniquesWithPersonalInformation(personalInformationId, SkillsAndTechniques);
    }

    @DeleteMapping("/{id}")
    public void deleteSkillsAndTechniques(@PathVariable Long id) {
        SkillsAndTechniquesService.deleteSkillsAndTechniques(id);
    }
}
