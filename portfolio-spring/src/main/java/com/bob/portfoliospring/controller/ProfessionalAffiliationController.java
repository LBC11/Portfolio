package com.bob.portfoliospring.controller;

import com.bob.portfoliospring.entities.ProfessionalAffiliation;
import com.bob.portfoliospring.services.ProfessionalAffiliationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professional-affiliation")
public class ProfessionalAffiliationController {

    @Autowired
    private ProfessionalAffiliationService professionalAffiliationService;

    @GetMapping("/")
    public List<ProfessionalAffiliation> getAllProfessionalAffiliations() {
        return professionalAffiliationService.getAllProfessionalAffiliations();
    }

    @GetMapping("/{id}")
    public ProfessionalAffiliation getProfessionalAffiliationById(@PathVariable Long id) {
        return professionalAffiliationService.getProfessionalAffiliationById(id);
    }

    @PostMapping("/")
    public ProfessionalAffiliation saveOrUpdateProfessionalAffiliation(@RequestParam Long personalInformationId, @RequestBody ProfessionalAffiliation professionalAffiliation) {
        return professionalAffiliationService.saveProfessionalAffiliationWithPersonalInformation(personalInformationId, professionalAffiliation);
    }

    @DeleteMapping("/{id}")
    public void deleteProfessionalAffiliation(@PathVariable Long id) {
        professionalAffiliationService.deleteProfessionalAffiliation(id);
    }

}
