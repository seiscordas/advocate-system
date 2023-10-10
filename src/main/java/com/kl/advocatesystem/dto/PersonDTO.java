package com.kl.advocatesystem.dto;

import com.kl.advocatesystem.entities.Office;
import com.kl.advocatesystem.entities.Person;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String documentNumber;
    private String generalRegistration;
    private LocalDate birthDate;
    private String companyName;
    private String stateRegistration;
    private LocalDateTime registrationTime;
    private LocalDateTime lastModificationTime;
    private Office office;
    private String active;

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.documentNumber = person.getDocumentNumber();
        this.generalRegistration = person.getGeneralRegistration();
        this.birthDate = person.getBirthDate();
        this.companyName = person.getCompanyName();
        this.stateRegistration = person.getStateRegistration();
        this.registrationTime = person.getRegistrationTime();
        this.lastModificationTime = person.getLastModificationTime();
        this.office = person.getOffice();
        this.active = person.getActive();
    }
}
