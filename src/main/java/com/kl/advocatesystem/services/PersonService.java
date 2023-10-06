package com.kl.advocatesystem.services;

import com.kl.advocatesystem.dto.PersonDTO;
import com.kl.advocatesystem.entities.Person;
import com.kl.advocatesystem.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;

    @Transactional
    public List<PersonDTO> findAll(){
        List<Person> personList = personRepository.findAll();
        return personList.stream().map(PersonDTO::new).collect(Collectors.toList());
    }
}
