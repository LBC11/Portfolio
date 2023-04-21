package com.bob.portfoliospring.web.dto;

import com.bob.portfoliospring.domain.model.Project;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProjectDTO {
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private String technologies;
    private Long personalInformationId;

    public static ProjectDTO fromEntity(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        dto.setStartDate(project.getStart_date());
        dto.setEndDate(project.getEnd_date());
        dto.setTechnologies(project.getTechnologies());
        dto.setPersonalInformationId(project.getPersonalInformation().getId());

        return dto;
    }
}
