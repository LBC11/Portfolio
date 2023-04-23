package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.Certification;
import com.bob.portfoliospring.web.dto.CertificationDTO;
import com.bob.portfoliospring.web.service.CertificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Certification")
@RestController
@RequestMapping("/api/certification")
public class CertificationController {

    @Autowired
    private CertificationService certificationService;

    @ApiOperation(value = "Get all certifications")
    @GetMapping("/")
    public List<CertificationDTO> getAllCertifications() {
        return certificationService.getAllCertifications();
    }

    @ApiOperation(value = "Get certification by ID")
    @GetMapping("/{id}")
    public CertificationDTO getCertificationById(@PathVariable Long id) {
        return certificationService.getCertificationById(id);
    }

    @ApiOperation(value = "Save or update certification")
    @PostMapping("/")
    public CertificationDTO saveOrUpdateCertification(@RequestParam Long personalInformationId, @RequestBody Certification certification) {
        return certificationService.saveCertificationWithPersonalInformation(personalInformationId, certification);
    }

    @ApiOperation(value = "Delete certification by ID")
    @DeleteMapping("/{id}")
    public void deleteCertification(@PathVariable Long id) {
        certificationService.deleteCertification(id);
    }
}
