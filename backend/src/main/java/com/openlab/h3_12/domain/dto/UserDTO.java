package com.openlab.h3_12.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record UserDTO(

        @NotBlank(message = "Name cannot be empty")
        @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
        String name,

        @NotBlank(message = "Email cannot be empty")
        @Email(message = "Email must be valid")
        String email,

        @NotBlank(message = "Wallet address cannot be empty")
        @Size(min = 42, max = 42, message = "Wallet address must be 42 characters")
        String walletAddress,

        @NotNull(message = "Creation date cannot be null")
        LocalDateTime createdAt,

        @NotNull(message = "Update date cannot be null")
        LocalDateTime updatedAt,

        @NotNull(message = "Last three initiatives cannot be null")
        List<InitiativeDTO> lastThreeInitiatives
) {
}
