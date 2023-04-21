package com.bob.portfoliospring.services;

import com.bob.portfoliospring.entities.PersonalInformation;
import com.bob.portfoliospring.entities.SemesterGrade;
import com.bob.portfoliospring.repository.PersonalInformationRepository;
import com.bob.portfoliospring.repository.SemesterGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SemesterGradeService {

    @Autowired
    private SemesterGradeRepository SemesterGradeRepository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

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

    public SemesterGrade saveSemesterGradeWithPersonalInformation(Long personalInformationId, SemesterGrade semesterGrade) {
        Optional<PersonalInformation> personalInformationOptional = personalInformationRepository.findById(personalInformationId);
        if (personalInformationOptional.isPresent()) {
            PersonalInformation personalInformation = personalInformationOptional.get();
            semesterGrade.setPersonalInformation(personalInformation);
            return SemesterGradeRepository.save(semesterGrade);
        }
        return null;
    }
}
