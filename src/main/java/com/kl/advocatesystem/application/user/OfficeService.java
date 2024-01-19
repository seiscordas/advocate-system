package com.kl.advocatesystem.application.user;

import com.kl.advocatesystem.dto.OfficeDTO;
import com.kl.advocatesystem.domain.entities.Office;
import com.kl.advocatesystem.repositories.OfficeRepository;
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
public class OfficeService {

    private OfficeRepository officeRepository;

    @Transactional
    public List<OfficeDTO> findAll(){
        List<Office> officeList = officeRepository.findAll();
        return officeList.stream().map(OfficeDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public OfficeDTO findById(Long id){
        Optional<Office> OptOffice = officeRepository.findById(id);
        Office office = OptOffice.orElseThrow(() -> new ResourceNotFoundException("Id not found " + id));
        return new OfficeDTO(office);
    }

    @Transactional
    public OfficeDTO insert(OfficeDTO officeDTO){
        Office office = new Office(officeDTO);
        office = officeRepository.save(office);
        office.setRegistrationTime(LocalDateTime.now());
        office.setLastModificationTime(LocalDateTime.now());
        return new OfficeDTO(office);
    }

    @Transactional
    public OfficeDTO update(Long id, OfficeDTO officeDTO){
        try {
            Office office = officeRepository.getReferenceById(id);
            copyDtoToEntity(officeDTO, office);
            office.setLastModificationTime(LocalDateTime.now());
            office = officeRepository.save(office);
            return new OfficeDTO(office);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    private void copyDtoToEntity(OfficeDTO officeDTO, Office office) {
        office.setName(office.getName());
        office.setCompanyName(officeDTO.getCompanyName());
        office.setStateRegistration(officeDTO.getStateRegistration());
        office.setDocumentNumber(officeDTO.getDocumentNumber());
        office.setMainOffice(officeDTO.getMainOffice());
        office.setActive(officeDTO.getActive());
        office.setRegistrationTime(officeDTO.getRegistrationTime());
        office.setLastModificationTime(officeDTO.getLastModificationTime());
    }
}
