package com.senseei.restaurant.dtos.dish;

public class NewDishDTO {
    private String name;
    private String description;
    private Double price;

    public NewDishDTO(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
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
}
