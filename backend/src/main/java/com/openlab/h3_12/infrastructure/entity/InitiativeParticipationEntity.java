package com.openlab.h3_12.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@Table(name = "InitiativeParticipation")
public class InitiativeParticipationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Relationship to User N:1
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    // Relación a InitiativeEntity N:1
    @ManyToOne
    @JoinColumn(name = "initiative_id", nullable = false)
    private InitiativeEntity initiative;

    @Column(name = "contribution")
    private Double contribution;

    @Column(name = "role")
    private String role;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
