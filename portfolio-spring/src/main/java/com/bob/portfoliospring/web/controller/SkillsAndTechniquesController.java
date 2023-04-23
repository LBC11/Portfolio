package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.SkillsAndTechniques;
import com.bob.portfoliospring.web.dto.SkillsAndTechniquesDTO;
import com.bob.portfoliospring.web.service.SkillsAndTechniquesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "SkillsAndTechniques")
@RestController
@RequestMapping("/api/skills-and-technique")
public class SkillsAndTechniquesController {

    @Autowired
    private SkillsAndTechniquesService SkillsAndTechniquesService;

    @ApiOperation(value = "Get all skills and techniques")
    @GetMapping("/")
    public List<SkillsAndTechniquesDTO> getAllSkillsAndTechniques() {
        return SkillsAndTechniquesService.getAllSkillsAndTechniques();
    }

    @ApiOperation(value = "Get skills and techniques by ID")
    @GetMapping("/{id}")
    public SkillsAndTechniquesDTO getSkillsAndTechniquesById(@PathVariable Long id) {
        return SkillsAndTechniquesService.getSkillsAndTechniquesById(id);
    }

    @ApiOperation(value = "Save or update skills and techniques")
    @PostMapping("/")
    public SkillsAndTechniquesDTO saveOrUpdateSkillsAndTechniques(@RequestParam Long personalInformationId, @RequestBody SkillsAndTechniques SkillsAndTechniques) {
        return SkillsAndTechniquesService.saveSkillsAndTechniquesWithPersonalInformation(personalInformationId, SkillsAndTechniques);
    }

    @ApiOperation(value = "Delete skills and techniques by ID")
    @DeleteMapping("/{id}")
    public void deleteSkillsAndTechniques(@PathVariable Long id) {
        SkillsAndTechniquesService.deleteSkillsAndTechniques(id);
    }
}
