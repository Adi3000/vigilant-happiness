package com.badache.vigilanthappiness.dto;

import com.badache.vigilanthappiness.entity.enums.IngredientType;

import java.util.HashSet;
import java.util.Set;

public class IngredientDto {

    private String name;

    private IngredientType type;

    Set<MealDto> meals = new HashSet<>();

    public IngredientDto(String name, IngredientType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IngredientType getType() {
        return type;
    }

    public void setType(IngredientType type) {
        this.type = type;
    }

    public Set<MealDto> getMeals() {
        return meals;
    }

    public void setMeals(Set<MealDto> meals) {
        this.meals = meals;
    }
}
