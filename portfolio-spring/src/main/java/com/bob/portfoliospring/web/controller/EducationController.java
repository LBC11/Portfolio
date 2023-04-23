package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.Education;
import com.bob.portfoliospring.web.dto.EducationDTO;
import com.bob.portfoliospring.web.service.EducationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Education")
@RestController
@RequestMapping("/api/education")
public class EducationController {


    @Autowired
    private EducationService educationService;

    @ApiOperation(value = "Get all educations")
    @GetMapping("/")
    public List<EducationDTO> getAllEducations() {
        return educationService.getAllEducations();
    }


    @ApiOperation(value = "Get education by ID")
    @GetMapping("/{id}")
    public EducationDTO getEducationById(@PathVariable Long id) {
        return educationService.getEducationById(id);
    }

    @ApiOperation(value = "Save or update education")
    @PostMapping("/")
    public EducationDTO saveOrUpdateEducation(@RequestParam Long personalInformationId, @RequestBody Education education) {
        return educationService.saveEducationWithPersonalInformation(personalInformationId, education);
    }

    @ApiOperation(value = "Delete education by ID")
    @DeleteMapping("/{id}")
    public void deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
    }
}
