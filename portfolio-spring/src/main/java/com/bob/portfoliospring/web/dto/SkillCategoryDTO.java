package com.bob.portfoliospring.web.dto;

import com.bob.portfoliospring.domain.model.SkillCategory;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class SkillCategoryDTO {
    private Long id;
    private String name;
    private Long skillsAndTechniquesId;
    private Set<SkillDTO> skills;

    // Getter, Setter, 기타 메소드 생략...

    public static SkillCategoryDTO fromEntity(SkillCategory skillCategory) {
        SkillCategoryDTO dto = new SkillCategoryDTO();
        dto.setId(skillCategory.getId());
        dto.setName(skillCategory.getName());
        dto.setSkillsAndTechniquesId(skillCategory.getSkillsAndTechniques().getId());
        dto.setSkills(skillCategory.getSkills().stream()
                .map(SkillDTO::fromEntity)
                .collect(Collectors.toSet()));

        return dto;
    }
}
