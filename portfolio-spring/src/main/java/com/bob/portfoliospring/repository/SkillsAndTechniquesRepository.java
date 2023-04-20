package com.bob.portfoliospring.repository;

import com.bob.portfoliospring.entities.SkillsAndTechniques;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillsAndTechniquesRepository extends JpaRepository<SkillsAndTechniques, Long> {
}
