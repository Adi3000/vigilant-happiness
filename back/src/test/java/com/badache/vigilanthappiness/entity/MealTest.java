package com.badache.vigilanthappiness.entity;

import com.badache.vigilanthappiness.dto.MealDto;
import com.badache.vigilanthappiness.entity.enums.IngredientType;
import com.badache.vigilanthappiness.entity.enums.MealType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MealTest {

    @Test
    public void shouldNotInitializeProperly()   {
        IllegalArgumentException thrownExceptionWhenNameNull = Assertions.assertThrows(
                IllegalArgumentException.class, () -> new Meal(null, MealType.MATIN),
                "How do you name a meal if you can't put words on it ?");

        Assertions.assertTrue(thrownExceptionWhenNameNull.getMessage().length() > 0);
    }

    @Test
    public void shouldInitializeProperly()  {
        Meal meal = new Meal("Aubergines grillées", MealType.SOIR);

        Assertions.assertNotNull(meal);
        Assertions.assertNotNull(meal.getIngredients());
        Assertions.assertEquals(0, meal.getIngredients().size());
    }

    @Test
    public void toDtoTest()     {
        final Meal meal = new Meal("Poulet rôti", MealType.MIDI);

        final Ingredient premierIngredient = new Ingredient("Poulet", IngredientType.VIANDE);
        final Ingredient secondIngredient = new Ingredient("Roti mdr", IngredientType.AUTRE);
        
        meal.addIngredient(premierIngredient);
        meal.addIngredient(secondIngredient);
        
        final MealDto resultDto = meal.toDto();
        
        Assertions.assertNotNull(resultDto);
        Assertions.assertEquals(meal.getName(), resultDto.getName());
        Assertions.assertEquals(meal.getType(), resultDto.getType());
        
        Assertions.assertNotNull(resultDto.getIngredients());
        Assertions.assertEquals(2, resultDto.getIngredients().size());
    }
}
