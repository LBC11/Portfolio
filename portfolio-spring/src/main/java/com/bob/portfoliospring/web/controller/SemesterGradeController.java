package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.SemesterGrade;
import com.bob.portfoliospring.web.dto.SemesterGradeDTO;
import com.bob.portfoliospring.web.service.SemesterGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/semester-grades")
public class SemesterGradeController {

    @Autowired
    private SemesterGradeService semesterGradeService;

    @GetMapping("/")
    public List<SemesterGradeDTO> getAllSemesterGrades() {
        return semesterGradeService.getAllSemesterGrades();
    }

    @GetMapping("/{id}")
    public SemesterGradeDTO getSemesterGradeById(@PathVariable Long id) {
        return semesterGradeService.getSemesterGradeById(id);
    }

    @PostMapping("/")
    public SemesterGradeDTO saveOrUpdateSemesterGrade(@RequestParam Long personalInformationId, @RequestBody SemesterGrade semesterGrade) {
        return semesterGradeService.saveSemesterGradeWithPersonalInformation(personalInformationId, semesterGrade);
    }

    @DeleteMapping("/{id}")
    public void deleteSemesterGrade(@PathVariable Long id) {
        semesterGradeService.deleteSemesterGrade(id);
    }
}
