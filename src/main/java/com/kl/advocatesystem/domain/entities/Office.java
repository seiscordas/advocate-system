package com.kl.advocatesystem.domain.entities;

import com.kl.advocatesystem.dto.OfficeDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_office")
public class Office implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String companyName;
    private String stateRegistration;
    private String documentNumber;
    private Boolean mainOffice;
    private Boolean active;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime registrationTime = LocalDateTime.now();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime lastModificationTime = LocalDateTime.now();

    public Office(OfficeDTO officeDTO) {
        this.id = officeDTO.getId();
        this.name = officeDTO.getName();
        this.companyName = officeDTO.getCompanyName();
        this.stateRegistration = officeDTO.getStateRegistration();
        this.documentNumber = officeDTO.getDocumentNumber();
        this.mainOffice = officeDTO.getMainOffice();
        this.registrationTime = officeDTO.getRegistrationTime();
        this.lastModificationTime = officeDTO.getLastModificationTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Office office = (Office) o;

        return id.equals(office.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
