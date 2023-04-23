package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.PersonalInformation;
import com.bob.portfoliospring.web.dto.PersonalInformationDTO;
import com.bob.portfoliospring.web.service.PersonalInformationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "PersonalInformation")
@RestController
@RequestMapping("/api/personal-information")
public class PersonalInformationController {

    @Autowired
    private PersonalInformationService personalInformationService;

    @ApiOperation(value = "Get all personal information")
    @GetMapping("/")
    public List<PersonalInformationDTO> getAllPersonalInformation() {
        return personalInformationService.getAllPersonalInformation();
    }

    @ApiOperation(value = "Get personal information by ID")
    @GetMapping("/{id}")
    public PersonalInformationDTO getPersonalInformationById(@PathVariable Long id) {
        return personalInformationService.getPersonalInformationById(id);
    }

    @ApiOperation(value = "Save or update personal information")
    @PostMapping("/")
    public PersonalInformationDTO saveOrUpdatePersonalInformation(@RequestBody PersonalInformation personalInformation) {
        return personalInformationService.saveOrUpdatePersonalInformation(personalInformation);
    }

    @ApiOperation(value = "Delete personal information by ID")
    @DeleteMapping("/{id}")
    public void deletePersonalInformation(@PathVariable Long id) {
        personalInformationService.deletePersonalInformation(id);
    }
}
