package com.bob.portfoliospring.services;

import com.bob.portfoliospring.entities.PersonalInformation;
import com.bob.portfoliospring.repository.PersonalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalInformationService {

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    public List<PersonalInformation> getAllPersonalInformation() {
        return personalInformationRepository.findAll();
    }

    public PersonalInformation getPersonalInformationById(Long id) {
        return personalInformationRepository.findById(id).orElse(null);
    }

    public PersonalInformation saveOrUpdatePersonalInformation(PersonalInformation personalInformation) {
        return personalInformationRepository.save(personalInformation);
    }

    public void deletePersonalInformation(Long id) {
        personalInformationRepository.deleteById(id);
    }
}
