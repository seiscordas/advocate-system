package com.kl.advocatesystem.dto;

import com.kl.advocatesystem.entities.Address;
import com.kl.advocatesystem.entities.Office;
import com.kl.advocatesystem.entities.Person;
import com.kl.advocatesystem.entities.enums.PersonCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

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
    private Person person;
    private Office office;

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.zipCode = address.getZipCode();
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.neighborhood = address.getNeighborhood();
        this.city = address.getCity();
        this.state = address.getState();
        this.country = address.getCountry();
        this.personCategory = address.getPersonCategory();
        this.mainAddress = address.getMainAddress();
        this.person = address.getPerson();
        this.office = address.getOffice();
    }
}
