package com.bob.portfoliospring.web.dto;

import com.bob.portfoliospring.domain.model.AwardAchievement;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AwardAchievementDTO {
    private Long id;
    private String name;
    private String description;
    private LocalDate dateReceived;

    // personalInformationId 필드는 AwardAchievement 엔티티에 있는 PersonalInformation 참조 대신 사용됩니다.
    private Long personalInformationId;

    public static AwardAchievementDTO fromEntity(AwardAchievement awardAchievement) {
        AwardAchievementDTO dto = new AwardAchievementDTO();
        dto.setId(awardAchievement.getId());
        dto.setName(awardAchievement.getName());
        dto.setDescription(awardAchievement.getDescription());
        dto.setDateReceived(awardAchievement.getDate_received());

        // PersonalInformation 객체 대신에 personalInformationId를 설정합니다.
        dto.setPersonalInformationId(awardAchievement.getPersonalInformation().getId());

        return dto;
    }
}

