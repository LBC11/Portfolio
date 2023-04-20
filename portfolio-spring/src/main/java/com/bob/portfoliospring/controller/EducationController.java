package com.bob.portfoliospring.controller;

import com.bob.portfoliospring.entities.Education;
import com.bob.portfoliospring.services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @GetMapping("/")
    public List<Education> getAllEducations() {
        return educationService.getAllEducations();
    }

    @GetMapping("/{id}")
    public Education getEducationById(@PathVariable Long id) {
        return educationService.getEducationById(id);
    }

    @PostMapping("/")
    public Education saveOrUpdateEducation(@RequestBody Education education) {
        return educationService.saveOrUpdateEducation(education);
    }

    @DeleteMapping("/{id}")
    public void deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
    }
}
