package com.bob.portfoliospring.services;

import com.bob.portfoliospring.entities.Certification;
import com.bob.portfoliospring.entities.PersonalInformation;
import com.bob.portfoliospring.repository.CertificationRepository;
import com.bob.portfoliospring.repository.PersonalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationService {

    @Autowired
    private CertificationRepository certificationRepository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    public List<Certification> getAllCertifications() {
        return certificationRepository.findAll();
    }

    public Certification getCertificationById(Long id) {
        return certificationRepository.findById(id).orElse(null);
    }

    public Certification saveOrUpdateCertification(Certification certification) {
        return certificationRepository.save(certification);
    }

    public void deleteCertification(Long id) {
        certificationRepository.deleteById(id);
    }

    public Certification saveCertificationWithPersonalInformation(Long personalInformationId, Certification certification) {
        Optional<PersonalInformation> personalInformationOptional = personalInformationRepository.findById(personalInformationId);
        if (personalInformationOptional.isPresent()) {
            PersonalInformation personalInformation = personalInformationOptional.get();
            certification.setPersonalInformation(personalInformation);
            return certificationRepository.save(certification);
        }
        return null;
    }
}
