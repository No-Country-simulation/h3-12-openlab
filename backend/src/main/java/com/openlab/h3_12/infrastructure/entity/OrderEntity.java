package com.openlab.h3_12.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
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

}
