package com.bob.portfoliospring.web.dto;

import com.bob.portfoliospring.domain.model.SkillsAndTechniques;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class SkillsAndTechniquesDTO {
    private Long id;
    private Long personalInformationId;
    private Set<SkillCategoryDTO> skillCategories;

    public static SkillsAndTechniquesDTO fromEntity(SkillsAndTechniques skillsAndTechniques) {
        SkillsAndTechniquesDTO dto = new SkillsAndTechniquesDTO();
        dto.setId(skillsAndTechniques.getId());
        dto.setPersonalInformationId(skillsAndTechniques.getPersonalInformation().getId());

        Set<SkillCategoryDTO> skillCategories = Optional.ofNullable(skillsAndTechniques.getSkillCategories())
                .orElse(Collections.emptySet())
                .stream()
                .map(SkillCategoryDTO::fromEntity)
                .collect(Collectors.toSet());
        dto.setSkillCategories(skillCategories);

        return dto;
    }
}
