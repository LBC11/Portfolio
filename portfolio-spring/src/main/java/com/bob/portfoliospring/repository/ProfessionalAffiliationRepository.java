package com.bob.portfoliospring.repository;

import com.bob.portfoliospring.entities.ProfessionalAffiliation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalAffiliationRepository extends JpaRepository<ProfessionalAffiliation, Long> {
}
