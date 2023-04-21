package com.bob.portfoliospring.web.dto;

import com.bob.portfoliospring.domain.model.Skill;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkillDTO {
    private Long id;
    private String name;
    private Long skillCategoryId;

    public static SkillDTO fromEntity(Skill skill) {
        SkillDTO dto = new SkillDTO();
        dto.setId(skill.getId());
        dto.setName(skill.getName());
        dto.setSkillCategoryId(skill.getSkillCategory().getId());

        return dto;
    }
}
