package com.kl.advocatesystem.application.user;

import com.kl.advocatesystem.domain.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(CredentialsDTO userRequest) {
        return User.builder()
                .login(userRequest.getLogin())
                .password(userRequest.getPassword())
                .build();
    }
}
