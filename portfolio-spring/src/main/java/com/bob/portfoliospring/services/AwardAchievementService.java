package com.bob.portfoliospring.services;

import com.bob.portfoliospring.entities.AwardAchievement;
import com.bob.portfoliospring.repository.AwardAchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardAchievementService {

    @Autowired
    private AwardAchievementRepository awardAchievementRepository;

    public List<AwardAchievement> getAllAwardAchievements() {
        return awardAchievementRepository.findAll();
    }

    public AwardAchievement getAwardAchievementById(Long id) {
        return awardAchievementRepository.findById(id).orElse(null);
    }

    public AwardAchievement saveOrUpdateAwardAchievement(AwardAchievement awardAchievement) {
        return awardAchievementRepository.save(awardAchievement);
    }

    public void deleteAwardAchievement(Long id) {
        awardAchievementRepository.deleteById(id);
    }
}
