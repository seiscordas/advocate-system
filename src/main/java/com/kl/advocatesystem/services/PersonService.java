package com.kl.advocatesystem.services;

import com.kl.advocatesystem.dto.PersonDTO;
import com.kl.advocatesystem.entities.Person;
import com.kl.advocatesystem.repositories.PersonRepository;
import com.kl.advocatesystem.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
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

    @Transactional
    public PersonDTO findById(Long id){
        Optional<Person> OptPerson = personRepository.findById(id);
        Person person = OptPerson.orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        return new PersonDTO(person);
    }

    @Transactional
    public PersonDTO insert(PersonDTO personDTO){
        Person person = new Person(personDTO);
        person = personRepository.save(person);
        person.setRegistrationTime(LocalDateTime.now());
        person.setLastModificationTime(LocalDateTime.now());
        return new PersonDTO(person);
    }

    @Transactional
    public PersonDTO update(Long id, PersonDTO personDTO){
        try {
            Person person = personRepository.getReferenceById(id);
            copyDtoToEntity(personDTO, person);
            person.setLastModificationTime(LocalDateTime.now());
            person = personRepository.save(person);
            return new PersonDTO(person);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    private void copyDtoToEntity(PersonDTO personDTO, Person person) {
        person.setName(person.getName());
        person.setDocumentNumber(personDTO.getDocumentNumber());
        person.setGeneralRegistration(personDTO.getGeneralRegistration());
        person.setBirthDate(personDTO.getBirthDate());
        person.setCompanyName(personDTO.getCompanyName());
        person.setStateRegistration(personDTO.getStateRegistration());
        person.setRegistrationTime(personDTO.getRegistrationTime());
        person.setLastModificationTime(personDTO.getLastModificationTime());
        person.setOffice(personDTO.getOffice());
        person.setActive(personDTO.getActive());
    }
}
