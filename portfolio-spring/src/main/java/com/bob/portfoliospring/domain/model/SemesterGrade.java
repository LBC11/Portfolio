package com.bob.portfoliospring.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "semester_grades")
public class SemesterGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int year;
    private int semester;
    private double gpa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;

}
