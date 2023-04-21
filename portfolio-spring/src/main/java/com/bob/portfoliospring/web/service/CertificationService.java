package com.bob.portfoliospring.web.service;

import com.bob.portfoliospring.domain.model.Certification;
import com.bob.portfoliospring.domain.model.PersonalInformation;
import com.bob.portfoliospring.domain.repository.CertificationRepository;
import com.bob.portfoliospring.domain.repository.PersonalInformationRepository;
import com.bob.portfoliospring.web.dto.CertificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CertificationService {

    @Autowired
    private CertificationRepository certificationRepository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    public List<CertificationDTO> getAllCertifications() {
        return certificationRepository.findAll().stream()
                .map(CertificationDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public CertificationDTO getCertificationById(Long id) {
        return certificationRepository.findById(id)
                .map(CertificationDTO::fromEntity)
                .orElse(null);
    }

    public void deleteCertification(Long id) {
        certificationRepository.deleteById(id);
    }

    public CertificationDTO saveCertificationWithPersonalInformation(Long personalInformationId, Certification certification) {
        Optional<PersonalInformation> personalInformationOptional = personalInformationRepository.findById(personalInformationId);
        if (personalInformationOptional.isPresent()) {
            PersonalInformation personalInformation = personalInformationOptional.get();
            certification.setPersonalInformation(personalInformation);
            Certification savedCertification = certificationRepository.save(certification);
            return CertificationDTO.fromEntity(savedCertification);
        }
        return null;
    }
}
