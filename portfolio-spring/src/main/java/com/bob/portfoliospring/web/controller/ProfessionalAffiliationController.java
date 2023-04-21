package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.ProfessionalAffiliation;
import com.bob.portfoliospring.web.dto.ProfessionalAffiliationDTO;
import com.bob.portfoliospring.web.service.ProfessionalAffiliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professional-affiliation")
public class ProfessionalAffiliationController {

    @Autowired
    private ProfessionalAffiliationService professionalAffiliationService;

    @GetMapping("/")
    public List<ProfessionalAffiliationDTO> getAllProfessionalAffiliations() {
        return professionalAffiliationService.getAllProfessionalAffiliations();
    }

    @GetMapping("/{id}")
    public ProfessionalAffiliationDTO getProfessionalAffiliationById(@PathVariable Long id) {
        return professionalAffiliationService.getProfessionalAffiliationById(id);
    }

    @PostMapping("/")
    public ProfessionalAffiliationDTO saveOrUpdateProfessionalAffiliation(@RequestParam Long personalInformationId, @RequestBody ProfessionalAffiliation professionalAffiliation) {
        return professionalAffiliationService.saveProfessionalAffiliationWithPersonalInformation(personalInformationId, professionalAffiliation);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessionalAffiliation(@PathVariable Long id) {
        professionalAffiliationService.deleteProfessionalAffiliation(id);
    }

}
