package com.openlab.h3_12.domain.service;

import com.openlab.h3_12.domain.dto.UserDTO;
import jakarta.validation.Valid;

import java.util.Optional;

public interface UserServicePort {
    Optional<UserDTO> getUserById(String userId);
    
    UserDTO registerUser(@Valid UserDTO userDTO);

    UserDTO updateUser(String userId, UserDTO userDTO);

    void deleteUser(String userId);

}
