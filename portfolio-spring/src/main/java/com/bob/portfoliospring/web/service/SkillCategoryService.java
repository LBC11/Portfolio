package com.bob.portfoliospring.web.service;

import com.bob.portfoliospring.domain.model.SkillsAndTechniques;
import com.bob.portfoliospring.domain.model.SkillCategory;
import com.bob.portfoliospring.domain.repository.SkillCategoryRepository;
import com.bob.portfoliospring.domain.repository.SkillsAndTechniquesRepository;
import com.bob.portfoliospring.web.dto.SkillCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SkillCategoryService {

    @Autowired
    private SkillCategoryRepository skillCategoryRepository;
    @Autowired
    private SkillsAndTechniquesRepository skillsAndTechniquesRepository;

    public List<SkillCategoryDTO> getAllSkillCategories() {
        return skillCategoryRepository.findAll().stream()
                .map(SkillCategoryDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public SkillCategoryDTO getSkillCategoryById(Long id) {
        return skillCategoryRepository.findById(id)
                .map(SkillCategoryDTO::fromEntity)
                .orElse(null);
    }

    public void deleteSkillCategory(Long id) {
        skillCategoryRepository.deleteById(id);
    }

    public SkillCategoryDTO saveSkillCategoryWithSkillsAndTechniques(Long skillsAndTechniquesId, SkillCategory skillCategory) {
        Optional<SkillsAndTechniques> skillsAndTechniquesOptional = skillsAndTechniquesRepository.findById(skillsAndTechniquesId);
        if (skillsAndTechniquesOptional.isPresent()) {
            SkillsAndTechniques skillsAndTechniques = skillsAndTechniquesOptional.get();
            skillCategory.setSkillsAndTechniques(skillsAndTechniques);
            SkillCategory savedSkillCategory = skillCategoryRepository.save(skillCategory);
            return SkillCategoryDTO.fromEntity(savedSkillCategory);
        }
        return null;
    }
}
