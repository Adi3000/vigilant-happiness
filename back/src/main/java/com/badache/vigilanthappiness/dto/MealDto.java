package com.badache.vigilanthappiness.dto;

import com.badache.vigilanthappiness.entity.enums.MealType;

import java.util.HashSet;
import java.util.Set;

public class MealDto {

    private String name;

    private MealType type;

    private Set<IngredientDto> ingredients = new HashSet<>();

    public MealDto(String name, MealType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MealType getType() {
        return type;
    }

    public void setType(MealType type) {
        this.type = type;
    }

    public Set<IngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientDto> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(IngredientDto ingredientDto) {
        if (ingredientDto == null)  {
            throw new IllegalArgumentException("Can't add a non-existing ingredient to mealDto " + this.getName());
        }

        // If not, may induce crossed calls > StackOverflowException
        if (!this.ingredients.contains(ingredientDto))  {
            this.ingredients.add(ingredientDto);
        }

        ingredientDto.getMeals().add(this);
    }
}
