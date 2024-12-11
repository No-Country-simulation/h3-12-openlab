package com.openlab.h3_12.infrastructure.entity;

import com.openlab.h3_12.domain.dto.OrderDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders") // order es palabra reservada
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Relación a InitiativeEntity N:1
    @ManyToOne
    @JoinColumn(name = "initiative_id", nullable = false)
    private InitiativeEntity initiative;

    //Relationship to User N:1
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private String orderType;
    private BigDecimal tokenAmount;
    private BigDecimal pricePerToken;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "update_at")
    private LocalDateTime updatedAt;

    public void updateFromDTO(OrderDTO orderDTO) {
        if (orderDTO.orderType() != null && !orderDTO.orderType().isBlank()) {
            this.orderType = orderDTO.orderType();
        }
        if (orderDTO.tokenAmount() != null && orderDTO.tokenAmount().compareTo(BigDecimal.ZERO) > 0) {
            this.tokenAmount = orderDTO.tokenAmount();
        }
        if (orderDTO.pricePerToken() != null && orderDTO.pricePerToken().compareTo(BigDecimal.ZERO) > 0) {
            this.pricePerToken = orderDTO.pricePerToken();
        }
        if (orderDTO.initiativeId() > 0) {
            InitiativeEntity initiative = new InitiativeEntity();
            initiative.setId(orderDTO.initiativeId());
            this.initiative = initiative;
        }
        if (orderDTO.userId() != null) {
            UserEntity user = new UserEntity();
            user.setId(orderDTO.userId());
            this.user = user;
        }
        this.updatedAt = LocalDateTime.now();
    }

    public BigDecimal calculateTotal() {
        return tokenAmount.multiply(pricePerToken);
    }
}
