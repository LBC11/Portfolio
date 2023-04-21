package com.bob.portfoliospring.web.controller;

import com.bob.portfoliospring.domain.model.AwardAchievement;
import com.bob.portfoliospring.web.dto.AwardAchievementDTO;
import com.bob.portfoliospring.web.service.AwardAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/award-achievement")
public class AwardAchievementController {

    @Autowired
    private AwardAchievementService awardAchievementService;

    @GetMapping("/")
    public List<AwardAchievementDTO> getAllAwardAchievements() {
        return awardAchievementService.getAllAwardAchievements();
    }

    @GetMapping("/{id}")
    public AwardAchievementDTO getAwardAchievementById(@PathVariable Long id) {
        return awardAchievementService.getAwardAchievementById(id);
    }

    @PostMapping("/")
    public AwardAchievementDTO saveOrUpdateAwardAchievement(@RequestParam Long personalInformationId, @RequestBody AwardAchievement awardAchievement) {
        return awardAchievementService.saveAwardAchievementWithPersonalInformation(personalInformationId, awardAchievement);
    }

    @DeleteMapping("/{id}")
    public void deleteAwardAchievement(@PathVariable Long id) {
        awardAchievementService.deleteAwardAchievement(id);
    }
}
