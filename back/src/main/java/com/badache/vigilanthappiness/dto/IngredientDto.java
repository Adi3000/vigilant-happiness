package com.badache.vigilanthappiness.dto;

import com.badache.vigilanthappiness.entity.enums.IngredientType;

import java.util.HashSet;
import java.util.Set;
public record IngredientDto (String name, IngredientType type, Set<MealDto> meals){
    public static IngredientDto from(String name, IngredientType type){
        return new IngredientDto(name, type, new HashSet<>(0));
    }
}
