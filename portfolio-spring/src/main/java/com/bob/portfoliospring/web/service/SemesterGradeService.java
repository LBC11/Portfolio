package com.bob.portfoliospring.web.service;

import com.bob.portfoliospring.domain.model.PersonalInformation;
import com.bob.portfoliospring.domain.model.SemesterGrade;
import com.bob.portfoliospring.domain.repository.PersonalInformationRepository;
import com.bob.portfoliospring.domain.repository.SemesterGradeRepository;
import com.bob.portfoliospring.web.dto.SemesterGradeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SemesterGradeService {

    @Autowired
    private SemesterGradeRepository semesterGradeRepository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    public List<SemesterGradeDTO> getAllSemesterGrades() {
        return semesterGradeRepository.findAll().stream()
                .map(SemesterGradeDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public SemesterGradeDTO getSemesterGradeById(Long id) {
        return semesterGradeRepository.findById(id)
                .map(SemesterGradeDTO::fromEntity)
                .orElse(null);
    }

    public void deleteSemesterGrade(Long id) {
        semesterGradeRepository.deleteById(id);
    }

    public SemesterGradeDTO saveSemesterGradeWithPersonalInformation(Long personalInformationId, SemesterGrade semesterGrade) {
        Optional<PersonalInformation> personalInformationOptional = personalInformationRepository.findById(personalInformationId);
        if (personalInformationOptional.isPresent()) {
            PersonalInformation personalInformation = personalInformationOptional.get();
            semesterGrade.setPersonalInformation(personalInformation);
            SemesterGrade savedSemesterGrade = semesterGradeRepository.save(semesterGrade);
            return SemesterGradeDTO.fromEntity(savedSemesterGrade);
        }
        return null;
    }
}
