package com.bob.portfoliospring.web.service;

import com.bob.portfoliospring.domain.model.PersonalInformation;
import com.bob.portfoliospring.domain.repository.PersonalInformationRepository;
import com.bob.portfoliospring.web.dto.PersonalInformationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonalInformationService {

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    public List<PersonalInformationDTO> getAllPersonalInformation() {
        return personalInformationRepository.findAll().stream()
                .map(PersonalInformationDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public PersonalInformationDTO getPersonalInformationById(Long id) {
        return personalInformationRepository.findById(id)
                .map(PersonalInformationDTO::fromEntity)
                .orElse(null);
    }

    public PersonalInformationDTO saveOrUpdatePersonalInformation(PersonalInformation personalInformation) {
        PersonalInformation savedPersonalInformation = personalInformationRepository.save(personalInformation);
        return PersonalInformationDTO.fromEntity(savedPersonalInformation);
    }

    public void deletePersonalInformation(Long id) {
        personalInformationRepository.deleteById(id);
    }
}
