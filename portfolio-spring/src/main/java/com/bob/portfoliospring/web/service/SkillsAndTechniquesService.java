package com.bob.portfoliospring.web.service;

import com.bob.portfoliospring.domain.model.PersonalInformation;
import com.bob.portfoliospring.domain.model.SkillsAndTechniques;
import com.bob.portfoliospring.domain.repository.PersonalInformationRepository;
import com.bob.portfoliospring.domain.repository.SkillsAndTechniquesRepository;
import com.bob.portfoliospring.web.dto.SkillsAndTechniquesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SkillsAndTechniquesService {

    @Autowired
    private SkillsAndTechniquesRepository skillsAndTechniquesRepository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    public List<SkillsAndTechniquesDTO> getAllSkillsAndTechniques() {
        return skillsAndTechniquesRepository.findAll().stream()
                .map(SkillsAndTechniquesDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public SkillsAndTechniquesDTO getSkillsAndTechniquesById(Long id) {
        return skillsAndTechniquesRepository.findById(id)
                .map(SkillsAndTechniquesDTO::fromEntity)
                .orElse(null);
    }

    public void deleteSkillsAndTechniques(Long id) {
        skillsAndTechniquesRepository.deleteById(id);
    }

    public SkillsAndTechniquesDTO saveSkillsAndTechniquesWithPersonalInformation(Long personalInformationId, SkillsAndTechniques skillsAndTechniques) {
        Optional<PersonalInformation> personalInformationOptional = personalInformationRepository.findById(personalInformationId);
        if (personalInformationOptional.isPresent()) {
            PersonalInformation personalInformation = personalInformationOptional.get();
            skillsAndTechniques.setPersonalInformation(personalInformation);
            SkillsAndTechniques savedSkillsAndTechniques = skillsAndTechniquesRepository.save(skillsAndTechniques);
            return SkillsAndTechniquesDTO.fromEntity(savedSkillsAndTechniques);
        }
        return null;
    }
}
