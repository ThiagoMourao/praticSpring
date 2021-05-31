package com.pratic.exercising.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratic.exercising.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
