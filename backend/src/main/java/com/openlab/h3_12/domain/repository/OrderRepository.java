package com.openlab.h3_12.domain.repository;

import com.openlab.h3_12.infrastructure.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity , Long> {
}
