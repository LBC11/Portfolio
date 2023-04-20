package com.bob.portfoliospring.controller;

import com.bob.portfoliospring.entities.PersonalInformation;
import com.bob.portfoliospring.services.PersonalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal-information")
public class PersonalInformationController {

    @Autowired
    private PersonalInformationService personalInformationService;

    @GetMapping("/")
    public List<PersonalInformation> getAllPersonalInformation() {
        return personalInformationService.getAllPersonalInformation();
    }

    @GetMapping("/{id}")
    public PersonalInformation getPersonalInformationById(@PathVariable Long id) {
        return personalInformationService.getPersonalInformationById(id);
    }

    @PostMapping("/")
    public PersonalInformation saveOrUpdatePersonalInformation(@RequestBody PersonalInformation personalInformation) {
        return personalInformationService.saveOrUpdatePersonalInformation(personalInformation);
    }

    @DeleteMapping("/{id}")
    public void deletePersonalInformation(@PathVariable Long id) {
        personalInformationService.deletePersonalInformation(id);
    }
}
