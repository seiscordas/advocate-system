package com.kl.advocatesystem.entities;

import com.kl.advocatesystem.dto.PersonDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_person")
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String documentNumber;
    private String generalRegistration;
    private LocalDate birthDate;
    private String companyName;
    private String stateRegistration;
    private String active;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime registrationTime = LocalDateTime.now();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime lastModificationTime = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "office_id", nullable=false)
    private Office office;

    public Person(PersonDTO personDTO) {
        this.id = personDTO.getId();
        this.name = personDTO.getName();
        this.documentNumber = personDTO.getDocumentNumber();
        this.generalRegistration = personDTO.getGeneralRegistration();
        this.birthDate = personDTO.getBirthDate();
        this.companyName = personDTO.getCompanyName();
        this.stateRegistration = personDTO.getStateRegistration();
        this.registrationTime = personDTO.getRegistrationTime();
        this.lastModificationTime = personDTO.getLastModificationTime();
        this.office = personDTO.getOffice();
        this.active = personDTO.getActive();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return id.equals(person.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
