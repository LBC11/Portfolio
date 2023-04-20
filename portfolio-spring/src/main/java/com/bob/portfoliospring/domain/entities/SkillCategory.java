package com.bob.portfoliospring.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "skill_categories")
public class SkillCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skills_and_techniques_id")
    private SkillsAndTechniques skillsAndTechniques;

    @OneToMany(mappedBy = "skillCategory", cascade = CascadeType.ALL)
    private Set<Skill> skills;
}
