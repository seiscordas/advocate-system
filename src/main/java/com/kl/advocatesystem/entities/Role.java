package com.kl.advocatesystem.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Entity
@Table(name = "tb_role")
@Data
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String authority;

    public Role() {
    }

    public Role(Long id, String authority) {
        this.id = id;
        this.authority = authority;
    }
}