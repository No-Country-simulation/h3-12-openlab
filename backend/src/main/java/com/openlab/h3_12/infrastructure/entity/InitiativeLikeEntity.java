package com.openlab.h3_12.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@Table(name = "InitiativeLike")
public class InitiativeLikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "liked_at")
    private Timestamp liked_at;
    //Relationship to InitiativeEntity N:1
    @ManyToOne
    @JoinColumn(name = "initiative_id", nullable = false)
    private InitiativeEntity initiative;
    //Relationship to User N:1
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
