package com.bob.portfoliospring.web.service;

import com.bob.portfoliospring.domain.model.SkillCategory;
import com.bob.portfoliospring.domain.model.Skill;
import com.bob.portfoliospring.domain.repository.SkillCategoryRepository;
import com.bob.portfoliospring.domain.repository.SkillRepository;
import com.bob.portfoliospring.web.dto.SkillDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;

    public List<SkillDTO> getAllSkills() {
        return skillRepository.findAll().stream()
                .map(SkillDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public SkillDTO getSkillById(Long id) {
        return skillRepository.findById(id)
                .map(SkillDTO::fromEntity)
                .orElse(null);
    }

    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

    public SkillDTO saveSkillWithSkillCategory(Long skillCategoryId, Skill skill) {
        Optional<SkillCategory> skillCategoryOptional = skillCategoryRepository.findById(skillCategoryId);
        if (skillCategoryOptional.isPresent()) {
            SkillCategory skillCategory = skillCategoryOptional.get();
            skill.setSkillCategory(skillCategory);
            Skill savedSkill = skillRepository.save(skill);
            return SkillDTO.fromEntity(savedSkill);
        }
        return null;
    }
}
