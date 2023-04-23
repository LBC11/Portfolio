package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.ProfessionalAffiliation;
import com.bob.portfoliospring.web.dto.ProfessionalAffiliationDTO;
import com.bob.portfoliospring.web.service.ProfessionalAffiliationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "ProfessionalAffiliation")
@RestController
@RequestMapping("/api/professional-affiliation")
public class ProfessionalAffiliationController {

    @Autowired
    private ProfessionalAffiliationService professionalAffiliationService;

    @ApiOperation(value = "Get all professional affiliations")
    @GetMapping("/")
    public List<ProfessionalAffiliationDTO> getAllProfessionalAffiliations() {
        return professionalAffiliationService.getAllProfessionalAffiliations();
    }

    @ApiOperation(value = "Get professional affiliation by ID")
    @GetMapping("/{id}")
    public ProfessionalAffiliationDTO getProfessionalAffiliationById(@PathVariable Long id) {
        return professionalAffiliationService.getProfessionalAffiliationById(id);
    }

    @ApiOperation(value = "Save or update professional affiliation")
    @PostMapping("/")
    public ProfessionalAffiliationDTO saveOrUpdateProfessionalAffiliation(@RequestParam Long personalInformationId, @RequestBody ProfessionalAffiliation professionalAffiliation) {
        return professionalAffiliationService.saveProfessionalAffiliationWithPersonalInformation(personalInformationId, professionalAffiliation);
    }

    @ApiOperation(value = "Delete professional affiliation by ID")
    @DeleteMapping("/{id}")
    public void deleteProfessionalAffiliation(@PathVariable Long id) {
        professionalAffiliationService.deleteProfessionalAffiliation(id);
    }

}
