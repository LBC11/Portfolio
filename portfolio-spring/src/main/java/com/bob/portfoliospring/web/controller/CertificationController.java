package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.Certification;
import com.bob.portfoliospring.web.dto.CertificationDTO;
import com.bob.portfoliospring.web.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certification")
public class CertificationController {

    @Autowired
    private CertificationService certificationService;

    @GetMapping("/")
    public List<CertificationDTO> getAllCertifications() {
        return certificationService.getAllCertifications();
    }

    @GetMapping("/{id}")
    public CertificationDTO getCertificationById(@PathVariable Long id) {
        return certificationService.getCertificationById(id);
    }

    @PostMapping("/")
    public CertificationDTO saveOrUpdateCertification(@RequestParam Long personalInformationId, @RequestBody Certification certification) {
        return certificationService.saveCertificationWithPersonalInformation(personalInformationId, certification);
    }

    @DeleteMapping("/{id}")
    public void deleteCertification(@PathVariable Long id) {
        certificationService.deleteCertification(id);
    }
}
