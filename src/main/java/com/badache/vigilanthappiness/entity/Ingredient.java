package com.badache.vigilanthappiness.entity;

import com.badache.vigilanthappiness.entity.enums.IngredientType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "INGREDIENT")
public class Ingredient {

    private Long ingredientId;

    private String name;

    private IngredientType type;

    Set<Meal> meals = new HashSet<>();

    public Ingredient(String name, IngredientType type) {
        this.name = name;
        this.type = type;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    public String getName() {
        return name;
    }

    @Column(name = "NAME")
    public void setName(String name) {
        this.name = name;
    }

    public IngredientType getType() {
        return type;
    }

    @Column(name = "TYPE")
    public void setType(IngredientType type) {
        this.type = type;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    @ManyToMany(mappedBy = "ingredients")
    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }
}
