package com.bob.portfoliospring.services;

import com.bob.portfoliospring.entities.SemesterGrade;
import com.bob.portfoliospring.repository.SemesterGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterGradeService {

    @Autowired
    private SemesterGradeRepository SemesterGradeRepository;

    public List<SemesterGrade> getAllSemesterGrades() {
        return SemesterGradeRepository.findAll();
    }

    public SemesterGrade getSemesterGradeById(Long id) {
        return SemesterGradeRepository.findById(id).orElse(null);
    }

    public SemesterGrade saveOrUpdateSemesterGrade(SemesterGrade SemesterGrade) {
        return SemesterGradeRepository.save(SemesterGrade);
    }

    public void deleteSemesterGrade(Long id) {
        SemesterGradeRepository.deleteById(id);
    }
}
