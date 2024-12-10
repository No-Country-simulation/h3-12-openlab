package com.openlab.h3_12.domain.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InitiativeRequestDTO {
    private String name;
    private String idea;
    private String problem;
    private String opportunity;
    private String solution;
    private String walletAddress;
    private String logo;
}
