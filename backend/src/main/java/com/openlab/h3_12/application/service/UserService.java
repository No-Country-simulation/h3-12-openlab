package com.openlab.h3_12.application.service;

import com.openlab.h3_12.domain.dto.UserDTO;
import com.openlab.h3_12.domain.service.UserServicePort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserServicePort {
    @Override
    public Optional<UserDTO> getUserById(String userId) {
        return Optional.empty();
    }

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO updateUser(String userId, UserDTO userDTO) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }
}
