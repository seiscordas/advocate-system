package com.kl.advocatesystem.dto;

import com.kl.advocatesystem.entities.Role;
import com.kl.advocatesystem.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime registrationTime;
    private LocalDateTime lastModificationTime;
    private Set<Role> roles = new HashSet<>();

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.registrationTime = user.getRegistrationTime();
        this.lastModificationTime = user.getLastModificationTime();
        this.roles = user.getRoles();
    }
}
