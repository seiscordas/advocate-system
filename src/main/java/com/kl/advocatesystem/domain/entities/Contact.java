package com.kl.advocatesystem.domain.entities;

import com.kl.advocatesystem.dto.ContactDTO;
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
@Table(name = "tb_contact")
public class Contact implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String phoneNumber;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime registrationTime = LocalDateTime.now();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime lastModificationTime = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "office_id", nullable=false)
    private Office office;

    public Contact(ContactDTO contactDTO) {
        this.id = contactDTO.getId();
        this.email = contactDTO.getEmail();
        this.phoneNumber = contactDTO.getPhoneNumber();
        this.registrationTime = contactDTO.getRegistrationTime();
        this.lastModificationTime = contactDTO.getLastModificationTime();
        this.person = contactDTO.getPerson();
        this.office = contactDTO.getOffice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return id.equals(contact.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
