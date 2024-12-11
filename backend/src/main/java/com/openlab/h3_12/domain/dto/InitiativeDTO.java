package com.openlab.h3_12.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record InitiativeDTO(
        @NotNull(message = "El ID no puede ser nulo")
        Long id,

        @NotBlank(message = "El título no puede estar vacío")
        @Size(max = 100, message = "El título debe tener un máximo de 100 caracteres")
        String title,

        @NotNull(message = "La fecha de participación no puede ser nula")
        LocalDateTime participationDate
) {
}
