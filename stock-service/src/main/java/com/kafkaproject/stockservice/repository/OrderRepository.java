package com.kafkaproject.stockservice.repository;

import com.kafkaproject.basedomains.dto.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
