package com.senseei.restaurant.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.senseei.restaurant.dtos.dish.NewDishDTO;
import com.senseei.restaurant.entities.Dish;
import com.senseei.restaurant.repositories.DishRepository;

@Service
public class DishService {
    
    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Dish create(NewDishDTO dto) {
        Dish dish = new Dish(dto);
        return dishRepository.save(dish);
    }

    public Dish findById(Long id) {
        return dishRepository.findById(id).orElse(null);
    }

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }
}
