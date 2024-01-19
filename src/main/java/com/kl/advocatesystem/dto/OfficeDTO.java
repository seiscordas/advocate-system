package com.kl.advocatesystem.dto;

import com.kl.advocatesystem.domain.entities.Office;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfficeDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String companyName;
    private String stateRegistration;
    private String documentNumber;
    private Boolean mainOffice;
    private Boolean active;
    private LocalDateTime registrationTime;
    private LocalDateTime lastModificationTime;

    public OfficeDTO(Office office) {
        this.id = office.getId();
        this.name = office.getName();
        this.companyName = office.getCompanyName();
        this.stateRegistration = office.getStateRegistration();
        this.documentNumber = office.getDocumentNumber();
        this.mainOffice = office.getMainOffice();
        this.registrationTime = office.getRegistrationTime();
        this.lastModificationTime = office.getLastModificationTime();
    }
}
