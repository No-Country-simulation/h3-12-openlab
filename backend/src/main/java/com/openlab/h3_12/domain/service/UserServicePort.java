package com.openlab.h3_12.domain.service;

import com.openlab.h3_12.domain.dto.UserDTO;

import java.util.Optional;

public interface UserServicePort {
    Optional<UserDTO> getUserById(String userId);

    UserDTO updateUser(Long userId, UserDTO userDTO);

    void deleteUser(Long userId);
}
