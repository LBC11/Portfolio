package com.bob.portfoliospring.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "professional_affiliations")
public class ProfessionalAffiliation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String organization;
    private String description;
    private LocalDate start_date;
    private LocalDate end_date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;
}
