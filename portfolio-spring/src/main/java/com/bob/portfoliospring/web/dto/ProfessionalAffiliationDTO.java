package com.bob.portfoliospring.web.dto;

import com.bob.portfoliospring.domain.model.ProfessionalAffiliation;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class ProfessionalAffiliationDTO {
    private Long id;
    private String name;
    private String organization;
    private String description;
    private Date startDate;
    private Date endDate;
    private Long personalInformationId;

    public static ProfessionalAffiliationDTO fromEntity(ProfessionalAffiliation professionalAffiliation) {
        ProfessionalAffiliationDTO dto = new ProfessionalAffiliationDTO();
        dto.setId(professionalAffiliation.getId());
        dto.setName(professionalAffiliation.getName());
        dto.setOrganization(professionalAffiliation.getOrganization());
        dto.setDescription(professionalAffiliation.getDescription());
        dto.setStartDate(professionalAffiliation.getStartDate());
        dto.setEndDate(professionalAffiliation.getEndDate());
        dto.setPersonalInformationId(professionalAffiliation.getPersonalInformation().getId());

        return dto;
    }
}
