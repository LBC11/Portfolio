package com.bob.portfoliospring.web.dto;

import com.bob.portfoliospring.domain.model.Certification;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CertificationDTO {
    private Long id;
    private String name;

    // personalInformationId 필드는 Certification 엔티티에 있는 PersonalInformation 참조 대신 사용됩니다.
    private Long personalInformationId;

    public static CertificationDTO fromEntity(Certification certification) {
        CertificationDTO dto = new CertificationDTO();
        dto.setId(certification.getId());
        dto.setName(certification.getName());

        // PersonalInformation 객체 대신에 personalInformationId를 설정합니다.
        dto.setPersonalInformationId(certification.getPersonalInformation().getId());

        return dto;
    }
}
