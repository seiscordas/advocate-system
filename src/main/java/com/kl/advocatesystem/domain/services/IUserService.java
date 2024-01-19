package com.kl.advocatesystem.domain.services;

import com.kl.advocatesystem.domain.AccessToken;
import com.kl.advocatesystem.domain.entities.User;

public interface IUserService {
    User getByLogin(String login);
    User insert(User user);
    AccessToken authenticate(String login, String password);
}
