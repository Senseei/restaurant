package com.senseei.restaurant.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senseei.restaurant.dtos.dish.NewDishDTO;
import com.senseei.restaurant.entities.Dish;
import com.senseei.restaurant.services.DishService;

@RestController
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }
    
    @GetMapping
    public List<Dish> findAll() {
        return dishService.findAll();
    }

    @PostMapping
    public Dish create(@RequestBody NewDishDTO dto) {
        return dishService.create(dto);
    }

    @GetMapping("/{id}")
    public Dish findById(@PathVariable Long id) {
        return dishService.findById(id);
    }
}
