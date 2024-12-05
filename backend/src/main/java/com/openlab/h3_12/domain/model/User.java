package com.openlab.h3_12.domain.model;

import java.time.LocalDateTime;
import java.util.List;

public class User {
    private Long id;
    private String name;
    private String email;
    private String walletAddress;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<InitiativeParticipation> lastThreeInitiatives;
}
