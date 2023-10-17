package com.kl.advocatesystem.services;

import com.kl.advocatesystem.dto.AddressDTO;
import com.kl.advocatesystem.entities.Address;
import com.kl.advocatesystem.repositories.AddressRepository;
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
public class AddressService {

    private AddressRepository addressRepository;

    @Transactional
    public List<AddressDTO> findAll(){
        List<Address> addressList = addressRepository.findAll();
        return addressList.stream().map(AddressDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public AddressDTO findById(Long id){
        Optional<Address> OptAddress = addressRepository.findById(id);
        Address address = OptAddress.orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        return new AddressDTO(address);
    }

    @Transactional
    public AddressDTO insert(AddressDTO addressDTO){
        Address address = new Address(addressDTO);
        address = addressRepository.save(address);
        address.setRegistrationTime(LocalDateTime.now());
        address.setLastModificationTime(LocalDateTime.now());
        return new AddressDTO(address);
    }

    @Transactional
    public AddressDTO update(Long id, AddressDTO addressDTO){
        try {
            Address address = addressRepository.getReferenceById(id);
            copyDtoToEntity(addressDTO, address);
            address.setLastModificationTime(LocalDateTime.now());
            address = addressRepository.save(address);
            return new AddressDTO(address);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    private void copyDtoToEntity(AddressDTO addressDTO, Address address) {
        address.setZipCode(addressDTO.getZipCode());
        address.setStreet(addressDTO.getStreet());
        address.setNumber(addressDTO.getNumber());
        address.setNeighborhood(addressDTO.getNeighborhood());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setCountry(addressDTO.getCountry());
        address.setPersonCategory(addressDTO.getPersonCategory());
        address.setMainAddress(addressDTO.getMainAddress());
        address.setRegistrationTime(addressDTO.getRegistrationTime());
        address.setLastModificationTime(addressDTO.getLastModificationTime());
        address.setPerson(addressDTO.getPerson());
        address.setOffice(addressDTO.getOffice());
    }
}
