package com.openlab.h3_12.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.catalina.User;

import java.security.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Dao")
public class DaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(name = "token_symbol")
    private String tokenSymbol;
    @Column(name = "created_At")
    private Timestamp createdAt;
    @Column(name = "updated_At")
    private Timestamp updatedAt;
    //Relationship to UserEntity N:1
    @ManyToOne
    @JoinColumn(name = "created_by")
    private UserEntity createdBy;

    //Relationship to Initiative 1:N
    @OneToMany(mappedBy = "dao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InitiativeEntity> initiatives;


}
