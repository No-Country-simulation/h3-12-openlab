package com.openlab.h3_12.application.service;

import com.openlab.h3_12.domain.dto.UserDTO;
import com.openlab.h3_12.domain.service.UserServicePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServicePort {
    @Override
    public Optional<UserDTO> getUserById(Long userId) {
        return Optional.empty();
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
}
