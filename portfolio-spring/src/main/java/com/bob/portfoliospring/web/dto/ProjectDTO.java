package com.bob.portfoliospring.web.dto;

import com.bob.portfoliospring.domain.model.Project;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ProjectDTO {
    private Long id;
    private String name;
    private List<String> descriptions;
    private Date startDate;
    private Date endDate;
    private String technologies;
    private Long personalInformationId;

    public static ProjectDTO fromEntity(Project project) {
        ProjectDTO dto = new ProjectDTO();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescriptions(project.getDescriptions());
        dto.setStartDate(project.getStartDate());
        dto.setEndDate(project.getEndDate());
        dto.setTechnologies(project.getTechnologies());
        dto.setPersonalInformationId(project.getPersonalInformation().getId());

        return dto;
    }
}
