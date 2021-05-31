package com.pratic.exercising.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratic.exercising.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
