package com.bob.portfoliospring.domain.repository;

import com.bob.portfoliospring.domain.model.SkillCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillCategoryRepository extends JpaRepository<SkillCategory, Long> {
}
