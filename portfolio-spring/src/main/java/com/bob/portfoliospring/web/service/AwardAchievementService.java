package com.bob.portfoliospring.web.service;

import com.bob.portfoliospring.domain.model.AwardAchievement;
import com.bob.portfoliospring.domain.model.PersonalInformation;
import com.bob.portfoliospring.domain.repository.AwardAchievementRepository;
import com.bob.portfoliospring.domain.repository.PersonalInformationRepository;
import com.bob.portfoliospring.web.dto.AwardAchievementDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AwardAchievementService {

    @Autowired
    private AwardAchievementRepository awardAchievementRepository;

    @Autowired
    private PersonalInformationRepository personalInformationRepository;

    public List<AwardAchievementDTO> getAllAwardAchievements() {
        return awardAchievementRepository.findAll().stream()
                .map(AwardAchievementDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public AwardAchievementDTO getAwardAchievementById(Long id) {
        return awardAchievementRepository.findById(id)
                .map(AwardAchievementDTO::fromEntity)
                .orElse(null);
    }

    public void deleteAwardAchievement(Long id) {
        awardAchievementRepository.deleteById(id);
    }

    public AwardAchievementDTO saveAwardAchievementWithPersonalInformation(Long personalInformationId, AwardAchievement awardAchievement) {
        Optional<PersonalInformation> personalInformationOptional = personalInformationRepository.findById(personalInformationId);
        if (personalInformationOptional.isPresent()) {
            PersonalInformation personalInformation = personalInformationOptional.get();
            awardAchievement.setPersonalInformation(personalInformation);
            AwardAchievement savedAwardAchievement = awardAchievementRepository.save(awardAchievement);
            return AwardAchievementDTO.fromEntity(savedAwardAchievement);
        }
        return null;
    }
}
