package com.bob.portfoliospring.repository;

import com.bob.portfoliospring.entities.AwardAchievement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardAchievementRepository extends JpaRepository<AwardAchievement, Long> {
}
