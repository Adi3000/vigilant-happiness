package com.badache.vigilanthappiness.dto;

import com.badache.vigilanthappiness.entity.enums.MealType;

import java.util.HashSet;
import java.util.Set;

public record MealDto (String name, MealType type, Set<IngredientDto> ingredients){


    public static MealDto from(String name, MealType type) {
        return new MealDto(name, type, new HashSet<>(0));
    }

    public void addIngredient(IngredientDto ingredientDto) {
        if (ingredientDto == null)  {
            throw new IllegalArgumentException("Can't add a non-existing ingredient to mealDto " + this.name());
        }

        // If not, may induce crossed calls > StackOverflowException
        if (!this.ingredients.contains(ingredientDto))  {
            this.ingredients.add(ingredientDto);
        }

        ingredientDto.meals().add(this);
    }
}
