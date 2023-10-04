package com.kl.advocatesystem.entities;

import com.kl.advocatesystem.entities.enums.PersonCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_adress")
public class Adress implements Serializable {
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

    @ManyToOne
    @JoinColumn(name = "person_id", nullable=false)
    private Person person;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Adress adress = (Adress) o;

        return id.equals(adress.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
