package com.bob.portfoliospring.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "affiliation_descriptions", joinColumns = @JoinColumn(name = "affiliation_id"))
    @Column(name = "description")
    private List<String> descriptions;

    private Date startDate;
    private Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;
}
