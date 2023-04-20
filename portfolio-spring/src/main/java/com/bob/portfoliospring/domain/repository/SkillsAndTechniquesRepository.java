package com.bob.portfoliospring.domain.repository;

import com.bob.portfoliospring.domain.entities.SkillsAndTechniques;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsAndTechniquesRepository extends JpaRepository<SkillsAndTechniques, Long> {
}
