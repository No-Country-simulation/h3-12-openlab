package com.openlab.h3_12.domain.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class InitiativeResponseDTO {
    private String name;
    private String idea;
    private String problem;
    private String opportunity;
    private String solution;
    private String daoTokenName;
    private String daoTokenSymbol;
    private String daoAddress;
    private List<String> daoPluginAddresses;
    private String daoNetwork;
    private String logoUrl;
}
