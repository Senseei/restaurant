package com.senseei.restaurant.entities;

import com.senseei.restaurant.dtos.dish.NewDishDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_dishes")
public class Dish {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column()
    private String name;

    @Column()
    private String description;

    @Column()
    private Double price;

    public Dish() {}

    public Dish(String name, String description, Double price) {
        setName(name);
        setDescription(description);
        setPrice(price);
    }

    public Dish(NewDishDTO dto) {
        setName(dto.getName());
        setDescription(dto.getDescription());
        setPrice(dto.getPrice());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish [description=" + description + ", id=" + id + ", name=" + name + ", price=" + price + "]";
    }
}
