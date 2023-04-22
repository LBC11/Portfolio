package com.bob.portfoliospring.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String institution;
    private String degree;
    private String major;
    private Date startDate;
    private Date endDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "education_descriptions")
    @Column(name = "description")
    private List<String> descriptions;

    @ManyToOne
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;
}
