package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.SemesterGrade;
import com.bob.portfoliospring.web.dto.SemesterGradeDTO;
import com.bob.portfoliospring.web.service.SemesterGradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "SemesterGrade")
@RestController
@RequestMapping("/api/semester-grades")
public class SemesterGradeController {

    @Autowired
    private SemesterGradeService semesterGradeService;

    @ApiOperation(value = "Get all semester grades")
    @GetMapping("/")
    public List<SemesterGradeDTO> getAllSemesterGrades() {
        return semesterGradeService.getAllSemesterGrades();
    }

    @ApiOperation(value = "Get semester grade by ID")
    @GetMapping("/{id}")
    public SemesterGradeDTO getSemesterGradeById(@PathVariable Long id) {
        return semesterGradeService.getSemesterGradeById(id);
    }

    @ApiOperation(value = "Save or update semester grade")
    @PostMapping("/")
    public SemesterGradeDTO saveOrUpdateSemesterGrade(@RequestParam Long personalInformationId, @RequestBody SemesterGrade semesterGrade) {
        return semesterGradeService.saveSemesterGradeWithPersonalInformation(personalInformationId, semesterGrade);
    }

    @ApiOperation(value = "Delete semester grade by ID")
    @DeleteMapping("/{id}")
    public void deleteSemesterGrade(@PathVariable Long id) {
        semesterGradeService.deleteSemesterGrade(id);
    }
}
