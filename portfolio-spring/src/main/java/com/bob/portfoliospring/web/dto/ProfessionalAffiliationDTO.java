package com.bob.portfoliospring.web.dto;

import com.bob.portfoliospring.domain.model.ProfessionalAffiliation;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProfessionalAffiliationDTO {
    private Long id;
    private String name;
    private String organization;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long personalInformationId;

    public static ProfessionalAffiliationDTO fromEntity(ProfessionalAffiliation professionalAffiliation) {
        ProfessionalAffiliationDTO dto = new ProfessionalAffiliationDTO();
        dto.setId(professionalAffiliation.getId());
        dto.setName(professionalAffiliation.getName());
        dto.setOrganization(professionalAffiliation.getOrganization());
        dto.setDescription(professionalAffiliation.getDescription());
        dto.setStartDate(professionalAffiliation.getStart_date());
        dto.setEndDate(professionalAffiliation.getEnd_date());
        dto.setPersonalInformationId(professionalAffiliation.getPersonalInformation().getId());

        return dto;
    }
}
