package com.bob.portfoliospring.services;

import com.bob.portfoliospring.entities.AwardAchievement;
import com.bob.portfoliospring.entities.PersonalInformation;
import com.bob.portfoliospring.repository.AwardAchievementRepository;
import com.bob.portfoliospring.repository.PersonalInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AwardAchievementService {

    @Autowired
    private AwardAchievementRepository awardAchievementRepository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

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

    public AwardAchievement saveAwardAchievementWithPersonalInformation(Long personalInformationId, AwardAchievement awardAchievement) {
        Optional<PersonalInformation> personalInformationOptional = personalInformationRepository.findById(personalInformationId);
        if (personalInformationOptional.isPresent()) {
            PersonalInformation personalInformation = personalInformationOptional.get();
            awardAchievement.setPersonalInformation(personalInformation);
            return awardAchievementRepository.save(awardAchievement);
        }
        return null;
    }
}
