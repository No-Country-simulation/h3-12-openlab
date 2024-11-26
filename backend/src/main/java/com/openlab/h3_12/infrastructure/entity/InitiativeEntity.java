package com.openlab.h3_12.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Initiative")
public class InitiativeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String problem;
    private String idea;
    private String solution;
    private String opportunity;
    @Column(name = "success_Indicator")
    private BigDecimal successIndicator;
    @Column(name = "created_At")
    private LocalDateTime createdAt;
    @Column(name = "updated_At")
    private LocalDateTime updatedAt;

    //Relationship to Dao N:1
    @ManyToOne
    @JoinColumn(name = "dao_id")
    private DaoEntity dao;

    //Relationship to Dao 1:N
    @OneToMany(mappedBy = "initiative", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InitiativeLikeEntity> initiativeLikes;

    // Relationship to InitiativeShareEntity 1:N
    @OneToMany(mappedBy = "initiative", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InitiativeShareEntity> initiativeShares;
    // Relationship to InitiativeParticipationEntity 1:N
    @OneToMany(mappedBy = "initiative", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InitiativeParticipationEntity> InitiativeParticipations;
    // Relationship to Order 1:N
    @OneToMany(mappedBy = "initiative", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> Orders;
}
