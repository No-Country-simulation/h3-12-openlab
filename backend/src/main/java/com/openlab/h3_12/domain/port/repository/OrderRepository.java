package com.openlab.h3_12.domain.repository;

import com.openlab.h3_12.infrastructure.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity , Long> {
    List<OrderEntity> findByUserId(Long userId);

    List<OrderEntity> findByInitiativeId(Long initiativeId);
}
