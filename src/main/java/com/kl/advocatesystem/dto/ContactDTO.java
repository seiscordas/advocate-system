package com.kl.advocatesystem.dto;

import com.kl.advocatesystem.domain.entities.Contact;
import com.kl.advocatesystem.domain.entities.Office;
import com.kl.advocatesystem.domain.entities.Person;
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
public class ContactDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private String phoneNumber;
    private LocalDateTime registrationTime;
    private LocalDateTime lastModificationTime;
    private Person person;
    private Office office;

    public ContactDTO(Contact contact) {
        this.id = contact.getId();
        this.email = contact.getEmail();
        this.phoneNumber = contact.getPhoneNumber();
        this.registrationTime = contact.getRegistrationTime();
        this.lastModificationTime = contact.getLastModificationTime();
        this.person = contact.getPerson();
        this.office = contact.getOffice();
    }
}
