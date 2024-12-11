package com.openlab.h3_12.application.mapper;

import com.openlab.h3_12.domain.dto.OrderDTO;
import com.openlab.h3_12.infrastructure.entity.OrderEntity;

public class OrderMapper {
    public static OrderDTO toDTO(OrderEntity savedOrder) {
        return OrderDTO.builder()
                .id(savedOrder.getId())
                .orderType(savedOrder.getOrderType())
                .tokenAmount(savedOrder.getTokenAmount())
                .pricePerToken(savedOrder.getPricePerToken())
                .createdAt(savedOrder.getCreatedAt())
                .updatedAt(savedOrder.getUpdatedAt())
                .build();
    }

    public static OrderEntity toEntity(OrderDTO orderDTO) {
        return OrderEntity.builder()
                .id(orderDTO.id())
                .orderType(orderDTO.orderType())
                .tokenAmount(orderDTO.tokenAmount())
                .pricePerToken(orderDTO.pricePerToken())
                .createdAt(orderDTO.createdAt())
                .updatedAt(orderDTO.updatedAt())
                .build();
    }
}
