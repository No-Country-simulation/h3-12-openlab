package com.openlab.h3_12.domain.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record OrderDTO(
        @NotNull(message = "The order ID cannot be null.")
        Long id,

        @NotNull(message = "The initiative ID cannot be null.")
        int initiativeId,

        @NotNull(message = "The user ID cannot be null.")
        Long userId,

        @NotBlank(message = "The order type cannot be empty.")
        @Pattern(regexp = "BUY|SELL", message = "The order type must be 'BUY' or 'SELL'.")
        String orderType,

        @NotNull(message = "The token quantity cannot be null.")
        @DecimalMin(value = "0.01", message = "The token quantity must be greater than 0.")
        BigDecimal tokenAmount,

        @NotNull(message = "The price per token cannot be null.")
        @DecimalMin(value = "0.01", message = "The price per token must be greater than 0.")
        BigDecimal pricePerToken,

        @NotNull(message = "Creation date cannot be null.")
        LocalDateTime createdAt,

        @NotNull(message = "Update date cannot be null.")
        LocalDateTime updatedAt
)
{
}
