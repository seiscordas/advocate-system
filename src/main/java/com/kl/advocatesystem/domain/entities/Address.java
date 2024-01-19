package com.kl.advocatesystem.domain.entities;

import com.kl.advocatesystem.dto.AddressDTO;
import com.kl.advocatesystem.domain.enums.PersonCategory;
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
@Table(name = "tb_address")
public class Address implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String zipCode;
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private PersonCategory personCategory;
    private Boolean mainAddress;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime registrationTime = LocalDateTime.now();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime lastModificationTime = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "office_id", nullable=false)
    private Office office;

    public Address(AddressDTO addressDTO) {
        this.id = addressDTO.getId();
        this.zipCode = addressDTO.getZipCode();
        this.street = addressDTO.getStreet();
        this.number = addressDTO.getNumber();
        this.neighborhood = addressDTO.getNeighborhood();
        this.city = addressDTO.getCity();
        this.state = addressDTO.getState();
        this.country = addressDTO.getCountry();
        this.personCategory = addressDTO.getPersonCategory();
        this.mainAddress = addressDTO.getMainAddress();
        this.registrationTime = addressDTO.getRegistrationTime();
        this.lastModificationTime = addressDTO.getLastModificationTime();
        this.person = addressDTO.getPerson();
        this.office = addressDTO.getOffice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        return id.equals(address.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
