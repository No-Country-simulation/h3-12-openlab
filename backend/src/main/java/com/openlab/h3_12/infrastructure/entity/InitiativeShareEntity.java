package com.openlab.h3_12.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "InitiativeShare")
public class InitiativeShareEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shared_at")
    private LocalDateTime shared_at;
    // Relación a InitiativeEntity N:1
    @ManyToOne
    @JoinColumn(name = "initiative_id", nullable = false)
    private InitiativeEntity initiative;
    //Relationship to User N:1
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
