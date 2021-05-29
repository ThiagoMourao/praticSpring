package com.pratic.exercising.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratic.exercising.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
