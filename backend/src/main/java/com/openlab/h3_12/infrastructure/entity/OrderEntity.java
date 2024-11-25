package com.openlab.h3_12.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Timestamp;

import java.math.BigDecimal;

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
    private Timestamp createdAt;
    private Timestamp updatedAt;

}
