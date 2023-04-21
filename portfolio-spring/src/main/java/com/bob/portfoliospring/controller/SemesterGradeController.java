package com.bob.portfoliospring.controller;

import com.bob.portfoliospring.entities.SemesterGrade;
import com.bob.portfoliospring.services.SemesterGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/semester-grades")
public class SemesterGradeController {

    @Autowired
    private SemesterGradeService semesterGradeService;

    @GetMapping("/")
    public List<SemesterGrade> getAllSemesterGrades() {
        return semesterGradeService.getAllSemesterGrades();
    }

    @GetMapping("/{id}")
    public SemesterGrade getSemesterGradeById(@PathVariable Long id) {
        return semesterGradeService.getSemesterGradeById(id);
    }

    @PostMapping("/")
    public SemesterGrade saveOrUpdateSemesterGrade(@RequestParam Long personalInformationId, @RequestBody SemesterGrade semesterGrade) {
        return semesterGradeService.saveSemesterGradeWithPersonalInformation(personalInformationId, semesterGrade);
    }

    @DeleteMapping("/{id}")
    public void deleteSemesterGrade(@PathVariable Long id) {
        semesterGradeService.deleteSemesterGrade(id);
    }
}
