package com.bob.portfoliospring.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "personal_information")
public class PersonalInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String degree;
    private String university;
    private String location;
    private String email;
    private String github;
    private String phone;
    private Date birth;
    private String nationality;
    private String language;

    @OneToMany(mappedBy = "personalInformation", cascade = CascadeType.ALL)
    private List<Education> educations;

    @OneToMany(mappedBy = "personalInformation", cascade = CascadeType.ALL)
    private List<ProfessionalAffiliation> professionalAffiliations;

    @OneToMany(mappedBy = "personalInformation", cascade = CascadeType.ALL)
    private List<Project> projects;

    @OneToOne(mappedBy = "personalInformation", cascade = CascadeType.ALL)
    private SkillsAndTechniques skillsAndTechniques;

    @OneToMany(mappedBy = "personalInformation", cascade = CascadeType.ALL)
    private List<AwardAchievement> awardsAchievements;

    @OneToMany(mappedBy = "personalInformation", cascade = CascadeType.ALL)
    private List<Certification> certifications;
}
