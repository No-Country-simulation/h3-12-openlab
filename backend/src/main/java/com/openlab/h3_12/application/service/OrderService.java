package com.openlab.h3_12.application.service;

import com.openlab.h3_12.application.mapper.OrderMapper;
import com.openlab.h3_12.domain.dto.OrderDTO;
import com.openlab.h3_12.domain.repository.OrderRepository;
import com.openlab.h3_12.domain.service.OrderServicePort;
import com.openlab.h3_12.infrastructure.entity.OrderEntity;
import com.openlab.h3_12.infrastructure.rest.interceptor.exception.OrderNotFoundException;
import com.openlab.h3_12.infrastructure.rest.interceptor.exception.OrderServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService implements OrderServicePort {
    private final OrderRepository orderRepository;


    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        try {
            OrderEntity order = OrderMapper.toEntity(orderDTO);
            OrderEntity savedOrder = orderRepository.save(order);
            return OrderMapper.toDTO(savedOrder);
        } catch (Exception e) {
            throw new OrderServiceException("Error creating order", e);
        }
    }

    @Override
    public Optional<OrderDTO> getOrderById(Long orderId) {
        try {
            return orderRepository.findById(orderId)
                    .map(OrderMapper::toDTO);
        } catch (Exception e) {
            throw new OrderServiceException("Error fetching order by ID: " + orderId, e);
        }
    }

    @Override
    public List<OrderDTO> getOrdersByUserId(Long userId) {
        try {
            return orderRepository.findByUserId(userId)
                    .stream()
                    .map(OrderMapper::toDTO)
                    .toList();
        } catch (Exception e) {
            throw new OrderServiceException("Error fetching orders for user ID: " + userId, e);
        }
    }

    @Override
    public List<OrderDTO> getOrdersByInitiativeId(Long initiativeId) {
        try {
            return orderRepository.findByInitiativeId(initiativeId)
                    .stream()
                    .map(OrderMapper::toDTO)
                    .toList();
        } catch (Exception e) {
            throw new OrderServiceException("Error fetching orders for initiative ID: " + initiativeId, e);
        }
    }

    @Override
    public OrderDTO updateOrder(Long orderId, OrderDTO orderDTO) {
        try {
            OrderEntity order = orderRepository.findById(orderId)
                    .orElseThrow(() -> new OrderNotFoundException("Order not found for ID: " + orderId));
            order.updateFromDTO(orderDTO);
            OrderEntity updatedOrder = orderRepository.save(order);
            return OrderMapper.toDTO(updatedOrder);
        } catch (OrderNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new OrderServiceException("Error updating order ID: " + orderId, e);
        }
    }

    @Override
    public void deleteOrder(Long orderId) {
        try {
            if (!orderRepository.existsById(orderId)) {
                throw new OrderNotFoundException("Order not found for ID: " + orderId);
            }

            orderRepository.deleteById(orderId);
        } catch (OrderNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new OrderServiceException("Error deleting order ID: " + orderId, e);
        }
    }

    @Override
    public BigDecimal calculateOrderTotal(Long orderId) {
        try {
            OrderEntity order = orderRepository.findById(orderId)
                    .orElseThrow(() -> new OrderNotFoundException("Order not found for ID: " + orderId));

            return order.calculateTotal();
        } catch (OrderNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new OrderServiceException("Error calculating total for order ID: " + orderId, e);
        }
    }
}
