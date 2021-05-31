package com.pratic.exercising.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratic.exercising.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
