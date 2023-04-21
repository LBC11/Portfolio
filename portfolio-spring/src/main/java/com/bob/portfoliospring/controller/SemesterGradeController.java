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
    private SemesterGradeService SemesterGradeService;

    @GetMapping("/")
    public List<SemesterGrade> getAllSemesterGrades() {
        return SemesterGradeService.getAllSemesterGrades();
    }

    @GetMapping("/{id}")
    public SemesterGrade getSemesterGradeById(@PathVariable Long id) {
        return SemesterGradeService.getSemesterGradeById(id);
    }

    @PostMapping("/")
    public SemesterGrade saveOrUpdateSemesterGrade(@RequestBody SemesterGrade SemesterGrade) {
        return SemesterGradeService.saveOrUpdateSemesterGrade(SemesterGrade);
    }

    @DeleteMapping("/{id}")
    public void deleteSemesterGrade(@PathVariable Long id) {
        SemesterGradeService.deleteSemesterGrade(id);
    }
}
