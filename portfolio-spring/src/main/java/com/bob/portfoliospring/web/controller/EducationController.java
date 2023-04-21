package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.Education;
import com.bob.portfoliospring.web.dto.EducationDTO;
import com.bob.portfoliospring.web.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @GetMapping("/")
    public List<EducationDTO> getAllEducations() {
        return educationService.getAllEducations();
    }

    @GetMapping("/{id}")
    public EducationDTO getEducationById(@PathVariable Long id) {
        return educationService.getEducationById(id);
    }

    @PostMapping("/")
    public EducationDTO saveOrUpdateEducation(@RequestParam Long personalInformationId, @RequestBody Education education) {
        return educationService.saveEducationWithPersonalInformation(personalInformationId, education);
    }

    @DeleteMapping("/{id}")
    public void deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
    }
}
