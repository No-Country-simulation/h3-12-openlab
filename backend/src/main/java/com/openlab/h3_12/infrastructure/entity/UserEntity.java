package com.openlab.h3_12.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "\"user\"")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(name = "wallet_address", nullable = false)
    private String walletAddress;
    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;
    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;

    //Relationship to Dao 1:N
    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DaoEntity> createdDaos;
    //Relationship to InitiativeLike 1:n
    @OneToMany(mappedBy = "user")
    private List<InitiativeLikeEntity> initiativeLikes;
    //Relationship to initiativeShare 1:n
    @OneToMany(mappedBy = "user")
    private List<InitiativeShareEntity> initiativeShare;
    @OneToMany(mappedBy = "user")
    private List<InitiativeParticipationEntity> initiativeParticipation;

    @OneToMany(mappedBy = "user")
    private List<OrderEntity> Orders;
}
