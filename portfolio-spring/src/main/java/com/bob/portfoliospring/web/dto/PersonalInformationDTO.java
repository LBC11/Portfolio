package com.bob.portfoliospring.web.dto;

import com.bob.portfoliospring.domain.model.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
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
        dto.setEducations(personalInformation.getEducations().stream()
                .map(EducationDTO::fromEntity)
                .collect(Collectors.toList()));
        dto.setSemesterGrades(personalInformation.getSemesterGrades().stream()
                .map(SemesterGradeDTO::fromEntity)
                .collect(Collectors.toList()));
        dto.setProfessionalAffiliations(personalInformation.getProfessionalAffiliations().stream()
                .map(ProfessionalAffiliationDTO::fromEntity)
                .collect(Collectors.toList()));
        dto.setProjects(personalInformation.getProjects().stream()
                .map(ProjectDTO::fromEntity)
                .collect(Collectors.toList()));
        dto.setSkillsAndTechniques(SkillsAndTechniquesDTO.fromEntity(personalInformation.getSkillsAndTechniques()));
        dto.setAwardsAchievements(personalInformation.getAwardsAchievements().stream()
                .map(AwardAchievementDTO::fromEntity)
                .collect(Collectors.toList()));
        dto.setCertifications(personalInformation.getCertifications().stream()
                .map(CertificationDTO::fromEntity)
                .collect(Collectors.toList()));

        return dto;
    }
}