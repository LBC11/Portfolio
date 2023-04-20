package com.bob.portfoliospring.domain.repository;

import com.bob.portfoliospring.domain.entities.ProfessionalAffiliation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalAffiliationRepository extends JpaRepository<ProfessionalAffiliation, Long> {
}
