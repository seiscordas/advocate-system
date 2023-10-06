package com.kl.advocatesystem.dto;

import com.kl.advocatesystem.entities.Office;
import com.kl.advocatesystem.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
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
    private Office office;

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
        this.documentNumber = person.getDocumentNumber();
        this.generalRegistration = person.getGeneralRegistration();
        this.birthDate = person.getBirthDate();
        this.companyName = person.getCompanyName();
        this.stateRegistration = person.getStateRegistration();
        this.registrationTime = person.getRegistrationTime();
        this.office = person.getOffice();
    }
}
