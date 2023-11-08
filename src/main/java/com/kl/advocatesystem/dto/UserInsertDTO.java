package com.kl.advocatesystem.dto;

import com.kl.advocatesystem.services.validation.UserInsertValid;
import lombok.Getter;
import lombok.Setter;

@UserInsertValid
public class UserInsertDTO extends UserDTO{
    @Getter
    @Setter
    private String password;
    UserInsertDTO(){
        super();
    }
}
