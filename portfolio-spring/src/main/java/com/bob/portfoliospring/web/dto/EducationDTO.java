package com.bob.portfoliospring.web.dto;

import com.bob.portfoliospring.domain.model.Education;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EducationDTO {
    private Long id;
    private String institution;
    private String degree;
    private String major;
    private Date startDate;
    private Date endDate;
    private List<String> descriptions;
    private Long personalInformationId;

    public static EducationDTO fromEntity(Education education) {
        EducationDTO dto = new EducationDTO();
        dto.setId(education.getId());
        dto.setInstitution(education.getInstitution());
        dto.setDegree(education.getDegree());
        dto.setMajor(education.getMajor());
        dto.setStartDate(education.getStartDate());
        dto.setEndDate(education.getEndDate());
        dto.setDescriptions(education.getDescriptions());
        dto.setPersonalInformationId(education.getPersonalInformation().getId());

        return dto;
    }
}
