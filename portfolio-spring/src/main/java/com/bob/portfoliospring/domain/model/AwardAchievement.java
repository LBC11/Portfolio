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
@Table(name = "awards_achievements")
public class AwardAchievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate date_received;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personal_information_id")
    private PersonalInformation personalInformation;
}