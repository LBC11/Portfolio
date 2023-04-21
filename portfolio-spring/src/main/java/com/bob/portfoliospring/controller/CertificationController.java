package com.bob.portfoliospring.controller;

import com.bob.portfoliospring.entities.Certification;
import com.bob.portfoliospring.services.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certification")
public class CertificationController {

    @Autowired
    private CertificationService certificationService;

    @GetMapping("/")
    public List<Certification> getAllCertifications() {
        return certificationService.getAllCertifications();
    }

    @GetMapping("/{id}")
    public Certification getCertificationById(@PathVariable Long id) {
        return certificationService.getCertificationById(id);
    }

    @PostMapping("/")
    public Certification saveOrUpdateCertification(@RequestParam Long personalInformationId, @RequestBody Certification certification) {
        return certificationService.saveCertificationWithPersonalInformation(personalInformationId, certification);
    }

    @DeleteMapping("/{id}")
    public void deleteCertification(@PathVariable Long id) {
        certificationService.deleteCertification(id);
    }
}
