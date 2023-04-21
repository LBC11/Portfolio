package com.bob.portfoliospring.domain.repository;

import com.bob.portfoliospring.domain.model.AwardAchievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardAchievementRepository extends JpaRepository<AwardAchievement, Long> {
}
