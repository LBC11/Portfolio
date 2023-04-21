package com.bob.portfoliospring.services;

import com.bob.portfoliospring.entities.Education;
import com.bob.portfoliospring.entities.PersonalInformation;
import com.bob.portfoliospring.repository.EducationRepository;
import com.bob.portfoliospring.repository.PersonalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    public List<Education> getAllEducations() {
        return educationRepository.findAll();
    }

    public Education getEducationById(Long id) {
        return educationRepository.findById(id).orElse(null);
    }

    public Education saveOrUpdateEducation(Education education) {
        return educationRepository.save(education);
    }

    public void deleteEducation(Long id) {
        educationRepository.deleteById(id);
    }

    public Education saveEducationWithPersonalInformation(Long personalInformationId, Education education) {
        Optional<PersonalInformation> personalInformationOptional = personalInformationRepository.findById(personalInformationId);
        if (personalInformationOptional.isPresent()) {
            PersonalInformation personalInformation = personalInformationOptional.get();
            education.setPersonalInformation(personalInformation);
            return educationRepository.save(education);
        }
        return null;
    }
}
