package com.bob.portfoliospring.web.service;

import com.bob.portfoliospring.domain.model.Education;
import com.bob.portfoliospring.domain.model.PersonalInformation;
import com.bob.portfoliospring.domain.repository.EducationRepository;
import com.bob.portfoliospring.domain.repository.PersonalInformationRepository;
import com.bob.portfoliospring.web.dto.EducationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    public List<EducationDTO> getAllEducations() {
        return educationRepository.findAll().stream()
                .map(EducationDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public EducationDTO getEducationById(Long id) {
        return educationRepository.findById(id)
                .map(EducationDTO::fromEntity)
                .orElse(null);
    }

    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }

    public EducationDTO saveEducationWithPersonalInformation(Long personalInformationId, Education education) {
        Optional<PersonalInformation> personalInformationOptional = personalInformationRepository.findById(personalInformationId);
        if (personalInformationOptional.isPresent()) {
            PersonalInformation personalInformation = personalInformationOptional.get();
            education.setPersonalInformation(personalInformation);
            Education savedEducation = educationRepository.save(education);
            return EducationDTO.fromEntity(savedEducation);
        }
        return null;
    }
}
