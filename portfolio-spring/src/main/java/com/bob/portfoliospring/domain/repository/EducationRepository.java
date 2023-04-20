package com.bob.portfoliospring.domain.repository;

import com.bob.portfoliospring.domain.entities.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
}
