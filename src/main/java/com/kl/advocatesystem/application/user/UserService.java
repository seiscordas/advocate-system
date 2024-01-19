package com.kl.advocatesystem.application.user;

import com.kl.advocatesystem.application.jwt.JwtService;
import com.kl.advocatesystem.application.user.exceptions.DatabaseException;
import com.kl.advocatesystem.application.user.exceptions.ResourceNotFoundException;
import com.kl.advocatesystem.domain.AccessToken;
import com.kl.advocatesystem.domain.entities.Role;
import com.kl.advocatesystem.domain.entities.User;
import com.kl.advocatesystem.domain.services.IUserService;
import com.kl.advocatesystem.dto.RoleDTO;
import com.kl.advocatesystem.dto.UserDTO;
import com.kl.advocatesystem.dto.UserInsertDTO;
import com.kl.advocatesystem.dto.UserUpdateDTO;
import com.kl.advocatesystem.repositories.RoleRepository;
import com.kl.advocatesystem.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private RoleRepository roleRepository;


    @Transactional(readOnly = true)
    public Page<UserDTO> findAllPaged(Pageable pageable) {
        Page<User> product = userRepository.findAll(pageable);
        return product.map(UserDTO::new);
    }

    @Transactional(readOnly = true)
    public UserDTO findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new UserDTO(entity);
    }

    @Transactional
    public UserDTO insert(UserInsertDTO dto) {
        User entity = new User();
        copyDtoToEntity(dto, entity);
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity = userRepository.save(entity);
        return new UserDTO(entity);

    }

    @Transactional
    public UserDTO update(Long id, UserUpdateDTO userUpdateDTO) {
        try {
            User entity = userRepository.getReferenceById(id);
            copyDtoToEntity(userUpdateDTO, entity);
            entity = userRepository.save(entity);
            return new UserDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    private void copyDtoToEntity(UserDTO userDTO, User user) {
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setLogin(userDTO.getLogin());

        user.getRoles().clear();
        for (RoleDTO roleDTO : userDTO.getRolesDTO()) {
            Role role = roleRepository.getReferenceById(roleDTO.getId());
            user.getRoles().add(role);
        }
    }

//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        User user = repository.findByLogin(login);
//        if (user == null) {
//            logger.error("User not found: " + login);
//            throw new UsernameNotFoundException("Login not found");
//        }
//        logger.info("User found: " + login);
//        return user;
//    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public User insert(User user) {
        return null;
    }

    @Override
    public AccessToken authenticate(String login, String password) {
        var user = getByLogin(login);
        if (user == null){
            return null;
        }

        boolean matches = passwordEncoder.matches(password, user.getPassword());
        if (matches){
            return jwtService.generateToken(user);
        }

        return null;
    }
}
