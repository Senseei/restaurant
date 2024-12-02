package com.senseei.restaurant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senseei.restaurant.entities.Dish;

public interface DishRepository extends JpaRepository<Dish, Long> {
    
}
