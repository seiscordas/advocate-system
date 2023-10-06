package com.kl.advocatesystem.resources;

import com.kl.advocatesystem.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonResource {
    @Autowired
    private PersonService personService;


}
