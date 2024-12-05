package com.openlab.h3_12.application.service;

import com.openlab.h3_12.domain.dto.OrderDTO;
import com.openlab.h3_12.domain.service.OrderServicePort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements OrderServicePort {
    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public Optional<OrderDTO> getOrderById(Long orderId) {
        return Optional.empty();
    }

    @Override
    public List<OrderDTO> getOrdersByUserId(Long userId) {
        return List.of();
    }

    @Override
    public List<OrderDTO> getOrdersByInitiativeId(Long initiativeId) {
        return List.of();
    }

    @Override
    public OrderDTO updateOrder(Long orderId, OrderDTO orderDTO) {
        return null;
    }

    @Override
    public void deleteOrder(Long orderId) {

    }

    @Override
    public BigDecimal calculateOrderTotal(Long orderId) {
        return null;
    }
}
