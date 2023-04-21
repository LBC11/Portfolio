package com.bob.portfoliospring.web.service;

import com.bob.portfoliospring.domain.model.PersonalInformation;
import com.bob.portfoliospring.domain.model.ProfessionalAffiliation;
import com.bob.portfoliospring.domain.repository.PersonalInformationRepository;
import com.bob.portfoliospring.domain.repository.ProfessionalAffiliationRepository;
import com.bob.portfoliospring.web.dto.ProfessionalAffiliationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfessionalAffiliationService {

    @Autowired
    private ProfessionalAffiliationRepository professionalAffiliationRepository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    public List<ProfessionalAffiliationDTO> getAllProfessionalAffiliations() {
        return professionalAffiliationRepository.findAll().stream()
                .map(ProfessionalAffiliationDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public ProfessionalAffiliationDTO getProfessionalAffiliationById(Long id) {
        return professionalAffiliationRepository.findById(id)
                .map(ProfessionalAffiliationDTO::fromEntity)
                .orElse(null);
    }

    public void deleteProfessionalAffiliation(Long id) {
        professionalAffiliationRepository.deleteById(id);
    }

    public ProfessionalAffiliationDTO saveProfessionalAffiliationWithPersonalInformation(Long personalInformationId, ProfessionalAffiliation professionalAffiliation) {
        Optional<PersonalInformation> personalInformationOptional = personalInformationRepository.findById(personalInformationId);
        if (personalInformationOptional.isPresent()) {
            PersonalInformation personalInformation = personalInformationOptional.get();
            professionalAffiliation.setPersonalInformation(personalInformation);
            ProfessionalAffiliation savedProfessionalAffiliation = professionalAffiliationRepository.save(professionalAffiliation);
            return ProfessionalAffiliationDTO.fromEntity(savedProfessionalAffiliation);
        }
        return null;
    }
}
