package com.bob.portfoliospring.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "skills_and_techniques")
public class SkillsAndTechniques {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;

    @OneToMany(mappedBy = "skillsAndTechniques", cascade = CascadeType.ALL)
    private Set<SkillCategory> skillCategories;
}
