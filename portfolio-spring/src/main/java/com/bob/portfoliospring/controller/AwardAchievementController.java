package com.bob.portfoliospring.controller;

import com.bob.portfoliospring.entities.AwardAchievement;
import com.bob.portfoliospring.services.AwardAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/award-achievement")
public class AwardAchievementController {

    @Autowired
    private AwardAchievementService awardAchievementService;

    @GetMapping("/")
    public List<AwardAchievement> getAllAwardAchievements() {
        return awardAchievementService.getAllAwardAchievements();
    }

    @GetMapping("/{id}")
    public AwardAchievement getAwardAchievementById(@PathVariable Long id) {
        return awardAchievementService.getAwardAchievementById(id);
    }

    @PostMapping("/")
    public AwardAchievement saveOrUpdateAwardAchievement(@RequestParam Long personalInformationId, @RequestBody AwardAchievement awardAchievement) {
        return awardAchievementService.saveAwardAchievementWithPersonalInformation(personalInformationId, awardAchievement);
    }

    @DeleteMapping("/{id}")
    public void deleteAwardAchievement(@PathVariable Long id) {
        awardAchievementService.deleteAwardAchievement(id);
    }
}
