package com.openlab.h3_12.domain.service;

import com.openlab.h3_12.domain.dto.OrderDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface OrderServicePort {
    OrderDTO createOrder(OrderDTO orderDTO);

    Optional<OrderDTO> getOrderById(Long orderId);

    List<OrderDTO> getOrdersByUserId(Long userId);

    List<OrderDTO> getOrdersByInitiativeId(Long initiativeId);

    OrderDTO updateOrder(Long orderId, OrderDTO orderDTO);

    void deleteOrder(Long orderId);

    BigDecimal calculateOrderTotal(Long orderId);
}
