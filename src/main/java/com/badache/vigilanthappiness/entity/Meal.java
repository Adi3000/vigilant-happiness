package com.badache.vigilanthappiness.entity;

import com.badache.vigilanthappiness.dto.MealDto;
import com.badache.vigilanthappiness.entity.enums.MealType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MEAL")
public class Meal {

    private Long id;

    private String name;

    private MealType type;

    Set<Ingredient> ingredients = new HashSet<>();

    public Meal()   {
        // Default constructor, needed for Hibernate
    }

    public Meal(String name, MealType type) {
        if (name == null || name.equals(""))    {
            throw new IllegalArgumentException("Meal must at least be named");
        }

        this.name = name;
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "NAME", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "TYPE")
    public MealType getType() {
        return type;
    }

    public void setType(MealType type) {
        this.type = type;
    }

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "MEAL_INGREDIENTS",
            joinColumns = { @JoinColumn(name = "mealId") },
            inverseJoinColumns = { @JoinColumn(name = "ingredientId") }
    )
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

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

    public MealDto toDto()  {
        final MealDto mealDto = new MealDto(this.name, this.type);

        this.ingredients.forEach(ingredientToConvert ->
                mealDto.addIngredient(ingredientToConvert.toDtoWithoutMeals()));

        return mealDto;
    }

    public MealDto toDtoWithoutIngredients() {
        return new MealDto(this.name, this.type);
    }
}
