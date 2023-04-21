package com.bob.portfoliospring.services;

import com.bob.portfoliospring.entities.PersonalInformation;
import com.bob.portfoliospring.entities.ProfessionalAffiliation;
import com.bob.portfoliospring.repository.PersonalInformationRepository;
import com.bob.portfoliospring.repository.ProfessionalAffiliationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessionalAffiliationService {

    @Autowired
    private ProfessionalAffiliationRepository professionalAffiliationRepository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    public List<ProfessionalAffiliation> getAllProfessionalAffiliations() {
        return professionalAffiliationRepository.findAll();
    }

    public ProfessionalAffiliation getProfessionalAffiliationById(Long id) {
        return professionalAffiliationRepository.findById(id).orElse(null);
    }

    public ProfessionalAffiliation saveOrUpdateProfessionalAffiliation(ProfessionalAffiliation professionalAffiliation) {
        return professionalAffiliationRepository.save(professionalAffiliation);
    }

    public void deleteProfessionalAffiliation(Long id) {
        professionalAffiliationRepository.deleteById(id);
    }

    public ProfessionalAffiliation saveProfessionalAffiliationWithPersonalInformation(Long personalInformationId, ProfessionalAffiliation professionalAffiliation) {
        Optional<PersonalInformation> personalInformationOptional = personalInformationRepository.findById(personalInformationId);
        if (personalInformationOptional.isPresent()) {
            PersonalInformation personalInformation = personalInformationOptional.get();
            professionalAffiliation.setPersonalInformation(personalInformation);
            return professionalAffiliationRepository.save(professionalAffiliation);
        }
        return null;
    }
}
