package com.bob.portfoliospring.web.dto;

import com.bob.portfoliospring.domain.model.SemesterGrade;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SemesterGradeDTO {
    private Long id;
    private int year;
    private int semester;
    private double gpa;
    private Long personalInformationId;

    public static SemesterGradeDTO fromEntity(SemesterGrade semesterGrade) {
        SemesterGradeDTO dto = new SemesterGradeDTO();
        dto.setId(semesterGrade.getId());
        dto.setYear(semesterGrade.getYear());
        dto.setSemester(semesterGrade.getSemester());
        dto.setGpa(semesterGrade.getGpa());
        dto.setPersonalInformationId(semesterGrade.getPersonalInformation().getId());

        return dto;
    }
}
