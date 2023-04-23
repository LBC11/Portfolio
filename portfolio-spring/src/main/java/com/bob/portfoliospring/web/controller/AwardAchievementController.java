package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.AwardAchievement;
import com.bob.portfoliospring.web.dto.AwardAchievementDTO;
import com.bob.portfoliospring.web.service.AwardAchievementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "AwardAchievement")
@RestController
@RequestMapping("/api/award-achievement")
public class AwardAchievementController {


    @Autowired
    private AwardAchievementService awardAchievementService;

    @ApiOperation(value = "Get all award achievements")
    @GetMapping("/")
    public List<AwardAchievementDTO> getAllAwardAchievements() {
        return awardAchievementService.getAllAwardAchievements();
    }

    @ApiOperation(value = "Get award achievement by ID")
    @GetMapping("/{id}")
    public AwardAchievementDTO getAwardAchievementById(@PathVariable Long id) {
        return awardAchievementService.getAwardAchievementById(id);
    }

    @ApiOperation(value = "Save or update award achievement")
    @PostMapping("/")
    public AwardAchievementDTO saveOrUpdateAwardAchievement(@RequestParam Long personalInformationId, @RequestBody AwardAchievement awardAchievement) {
        return awardAchievementService.saveAwardAchievementWithPersonalInformation(personalInformationId, awardAchievement);
    }

    @ApiOperation(value = "Delete award achievement by ID")
    @DeleteMapping("/{id}")
    public void deleteAwardAchievement(@PathVariable Long id) {
        awardAchievementService.deleteAwardAchievement(id);
    }
}
