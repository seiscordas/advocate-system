package com.kl.advocatesystem.application.user;

import com.kl.advocatesystem.dto.ContactDTO;
import com.kl.advocatesystem.domain.entities.Contact;
import com.kl.advocatesystem.repositories.ContactRepository;
import com.kl.advocatesystem.application.user.exceptions.ResourceNotFoundException;
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
public class ContactService {

    private ContactRepository contactRepository;

    @Transactional
    public List<ContactDTO> findAll(){
        List<Contact> contactList = contactRepository.findAll();
        return contactList.stream().map(ContactDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public ContactDTO findById(Long id){
        Optional<Contact> OptContact = contactRepository.findById(id);
        Contact contact = OptContact.orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        return new ContactDTO(contact);
    }

    @Transactional
    public ContactDTO insert(ContactDTO contactDTO){
        Contact contact = new Contact(contactDTO);
        contact = contactRepository.save(contact);
        contact.setRegistrationTime(LocalDateTime.now());
        contact.setLastModificationTime(LocalDateTime.now());
        return new ContactDTO(contact);
    }

    @Transactional
    public ContactDTO update(Long id, ContactDTO contactDTO){
        try {
            Contact contact = contactRepository.getReferenceById(id);
            copyDtoToEntity(contactDTO, contact);
            contact.setLastModificationTime(LocalDateTime.now());
            contact = contactRepository.save(contact);
            return new ContactDTO(contact);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    private void copyDtoToEntity(ContactDTO contactDTO, Contact contact) {
        contact.setEmail(contactDTO.getEmail());
        contact.setPhoneNumber(contactDTO.getPhoneNumber());
        contact.setRegistrationTime(contactDTO.getRegistrationTime());
        contact.setLastModificationTime(contactDTO.getLastModificationTime());
        contact.setPerson(contactDTO.getPerson());
        contact.setOffice(contactDTO.getOffice());
    }
}
