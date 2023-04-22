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
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "project_descriptions")
    @Column(name = "description")
    private List<String> descriptions;

    private Date startDate;
    private Date endDate;
    private String technologies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;
}
