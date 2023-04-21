package com.bob.portfoliospring.services;

import com.bob.portfoliospring.entities.PersonalInformation;
import com.bob.portfoliospring.entities.SkillsAndTechniques;
import com.bob.portfoliospring.repository.PersonalInformationRepository;
import com.bob.portfoliospring.repository.SkillsAndTechniquesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillsAndTechniquesService {

    @Autowired
    private SkillsAndTechniquesRepository skillsAndTechniquesRepository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    public List<SkillsAndTechniques> getAllSkillsAndTechniques() {
        return skillsAndTechniquesRepository.findAll();
    }

    public SkillsAndTechniques getSkillsAndTechniquesById(Long id) {
        return skillsAndTechniquesRepository.findById(id).orElse(null);
    }

    public SkillsAndTechniques saveOrUpdateSkillsAndTechniques(SkillsAndTechniques skillsAndTechniques) {
        return skillsAndTechniquesRepository.save(skillsAndTechniques);
    }

    public void deleteSkillsAndTechniques(Long id) {
        skillsAndTechniquesRepository.deleteById(id);
    }

    public SkillsAndTechniques saveSkillsAndTechniquesWithPersonalInformation(Long personalInformationId, SkillsAndTechniques skillsAndTechniques) {
        Optional<PersonalInformation> personalInformationOptional = personalInformationRepository.findById(personalInformationId);
        if (personalInformationOptional.isPresent()) {
            PersonalInformation personalInformation = personalInformationOptional.get();
            skillsAndTechniques.setPersonalInformation(personalInformation);
            return skillsAndTechniquesRepository.save(skillsAndTechniques);
        }
        return null;
    }
}
