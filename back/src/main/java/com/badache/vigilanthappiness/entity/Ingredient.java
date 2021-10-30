package com.badache.vigilanthappiness.entity;

import com.badache.vigilanthappiness.dto.IngredientDto;
import com.badache.vigilanthappiness.entity.enums.IngredientType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "INGREDIENT")
public class Ingredient {

    private Long id;

    private String name;

    private IngredientType type;

    Set<Meal> meals = new HashSet<>();

    public Ingredient(String name, IngredientType type) {
        this.name = name;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "TYPE")
    public IngredientType getType() {
        return type;
    }

    public void setType(IngredientType type) {
        this.type = type;
    }

    @ManyToMany(mappedBy = "ingredients")
    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

    public IngredientDto toDto()  {
        final IngredientDto ingredientDto =
            IngredientDto.from(this.name, this.type);

        this.meals.forEach(mealToConvert ->
                ingredientDto.meals().add(mealToConvert.toDtoWithoutIngredients()));

        return ingredientDto;
    }

    public IngredientDto toDtoWithoutMeals()    {
        return IngredientDto.from(this.name, this.type);
    }
}
