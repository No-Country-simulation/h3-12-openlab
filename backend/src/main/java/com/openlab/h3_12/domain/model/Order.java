package com.openlab.h3_12.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Order {
    private Long id;
    private Long initiativeId;
    private Long userId;
    private String orderType;
    private BigDecimal tokenAmount;
    private BigDecimal pricePerToken;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
