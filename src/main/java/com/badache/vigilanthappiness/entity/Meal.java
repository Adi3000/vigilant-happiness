package com.badache.vigilanthappiness.entity;

import com.badache.vigilanthappiness.entity.enums.MealType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MEAL")
public class Meal {

    private Long mealId;

    private String name;

    private MealType type;

    Set<Ingredient> ingredients = new HashSet<>();

    public Meal(String name, MealType type) {
        this.name = name;
        this.type = type;
    }

    public long getMealId() {
        return mealId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public void setMealId(long mealId) {
        this.mealId = mealId;
    }

    public String getName() {
        return name;
    }

    @Column(name = "NAME")
    public void setName(String name) {
        this.name = name;
    }

    public MealType getType() {
        return type;
    }

    @Column(name = "TYPE")
    public void setType(MealType type) {
        this.type = type;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "MEAL_INGREDIENTS",
            joinColumns = { @JoinColumn(name = "mealId") },
            inverseJoinColumns = { @JoinColumn(name = "ingredientId") }
    )
    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient addedIngredient)     {
        if (addedIngredient == null)    {
            throw new IllegalArgumentException("Can't add a non-existing ingredient to meal " + this.getName());
        }

        this.ingredients.add(addedIngredient);
        addedIngredient.getMeals().add(this);
    }
}
