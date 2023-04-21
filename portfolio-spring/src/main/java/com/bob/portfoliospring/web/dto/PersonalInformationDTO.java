package com.bob.portfoliospring.web.dto;

import com.bob.portfoliospring.domain.model.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
public class PersonalInformationDTO {
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

    private List<EducationDTO> educations;
    private List<SemesterGradeDTO> semesterGrades;
    private List<ProfessionalAffiliationDTO> professionalAffiliations;
    private List<ProjectDTO> projects;
    private SkillsAndTechniquesDTO skillsAndTechniques;
    private List<AwardAchievementDTO> awardsAchievements;
    private List<CertificationDTO> certifications;

    public static PersonalInformationDTO fromEntity(PersonalInformation personalInformation) {
        PersonalInformationDTO dto = new PersonalInformationDTO();
        dto.setId(personalInformation.getId());
        dto.setName(personalInformation.getName());
        dto.setDegree(personalInformation.getDegree());
        dto.setUniversity(personalInformation.getUniversity());
        dto.setLocation(personalInformation.getLocation());
        dto.setEmail(personalInformation.getEmail());
        dto.setGithub(personalInformation.getGithub());
        dto.setPhone(personalInformation.getPhone());
        dto.setBirth(personalInformation.getBirth());
        dto.setNationality(personalInformation.getNationality());
        dto.setLanguage(personalInformation.getLanguage());

        // 연관된 객체들도 DTO 로 변환하는 코드를 추가합니다.
        // null 일경우 빈 List 를 반환합니다.
        List<EducationDTO> educations = Optional.ofNullable(personalInformation.getEducations())
                .orElse(Collections.emptyList())
                .stream()
                .map(EducationDTO::fromEntity)
                .collect(Collectors.toList());
        dto.setEducations(educations);

        List<SemesterGradeDTO> semesterGrades = Optional.ofNullable(personalInformation.getSemesterGrades())
                .orElse(Collections.emptyList())
                .stream()
                .map(SemesterGradeDTO::fromEntity)
                .collect(Collectors.toList());
        dto.setSemesterGrades(semesterGrades);

        List<ProfessionalAffiliationDTO> professionalAffiliations = Optional.ofNullable(personalInformation.getProfessionalAffiliations())
                .orElse(Collections.emptyList())
                .stream()
                .map(ProfessionalAffiliationDTO::fromEntity)
                .collect(Collectors.toList());
        dto.setProfessionalAffiliations(professionalAffiliations);

        List<ProjectDTO> projects = Optional.ofNullable(personalInformation.getProjects())
                .orElse(Collections.emptyList())
                .stream()
                .map(ProjectDTO::fromEntity)
                .collect(Collectors.toList());
        dto.setProjects(projects);

        SkillsAndTechniquesDTO skillsAndTechniques = Optional.ofNullable(personalInformation.getSkillsAndTechniques())
                .map(SkillsAndTechniquesDTO::fromEntity)
                .orElse(null);
        dto.setSkillsAndTechniques(skillsAndTechniques);

        List<AwardAchievementDTO> awardsAchievements = Optional.ofNullable(personalInformation.getAwardsAchievements())
                .orElse(Collections.emptyList())
                .stream()
                .map(AwardAchievementDTO::fromEntity)
                .collect(Collectors.toList());
        dto.setAwardsAchievements(awardsAchievements);

        List<CertificationDTO> certifications = Optional.ofNullable(personalInformation.getCertifications())
                .orElse(Collections.emptyList())
                .stream()
                .map(CertificationDTO::fromEntity)
                .collect(Collectors.toList());
        dto.setCertifications(certifications);

        return dto;
    }
}