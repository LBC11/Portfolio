package com.bob.portfoliospring.domain.repository;

import com.bob.portfoliospring.domain.model.SemesterGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterGradeRepository extends JpaRepository<SemesterGrade, Long> {
}
