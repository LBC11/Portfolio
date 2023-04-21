package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.PersonalInformation;
import com.bob.portfoliospring.web.dto.PersonalInformationDTO;
import com.bob.portfoliospring.web.service.PersonalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal-information")
public class PersonalInformationController {

    @Autowired
    private PersonalInformationService personalInformationService;

    @GetMapping("/")
    public List<PersonalInformationDTO> getAllPersonalInformation() {
        return personalInformationService.getAllPersonalInformation();
    }

    @GetMapping("/{id}")
    public PersonalInformationDTO getPersonalInformationById(@PathVariable Long id) {
        return personalInformationService.getPersonalInformationById(id);
    }

    @PostMapping("/")
    public PersonalInformationDTO saveOrUpdatePersonalInformation(@RequestBody PersonalInformation personalInformation) {
        return personalInformationService.saveOrUpdatePersonalInformation(personalInformation);
    }

    @DeleteMapping("/{id}")
    public void deletePersonalInformation(@PathVariable Long id) {
        personalInformationService.deletePersonalInformation(id);
    }
}
