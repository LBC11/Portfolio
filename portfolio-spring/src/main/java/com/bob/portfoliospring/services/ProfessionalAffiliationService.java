package com.bob.portfoliospring.services;

import com.bob.portfoliospring.entities.ProfessionalAffiliation;
import com.bob.portfoliospring.repository.ProfessionalAffiliationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalAffiliationService {

    @Autowired
    private ProfessionalAffiliationRepository professionalAffiliationRepository;

    public List<ProfessionalAffiliation> getAllProfessionalAffiliation() {
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
}
