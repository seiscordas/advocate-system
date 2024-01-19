package com.kl.advocatesystem.resources;

import com.kl.advocatesystem.application.user.CredentialsDTO;
import com.kl.advocatesystem.application.user.UserMapper;
import com.kl.advocatesystem.application.user.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginResource {

    Logger logger = LoggerFactory.getLogger(LoginResource.class);

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping("/user")
    public String getUser() {
        System.out.println("getting users");
        return "Users";
    }

    @GetMapping("/current-user")
    public String getCurrentUser(Principal principal) {
        return principal.getName();
    }

    @PostMapping("/login")
    public ResponseEntity authenticate(@RequestBody CredentialsDTO credentialsDTO) {
        var token = userService.authenticate(credentialsDTO.getLogin(), credentialsDTO.getPassword());

        if(token == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok(token);
    }

}


