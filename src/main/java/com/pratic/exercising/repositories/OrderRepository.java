package com.pratic.exercising.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratic.exercising.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
