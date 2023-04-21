package com.bob.portfoliospring.repository;

import com.bob.portfoliospring.entities.SemesterGrade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterGradeRepository extends JpaRepository<SemesterGrade, Long> {
}
