package com.badache.vigilanthappiness.services.meal;

import com.badache.vigilanthappiness.entity.Ingredient;
import com.badache.vigilanthappiness.entity.Meal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MealServiceTest {

    @Autowired
    private MealService mealService;

    @Test
    public void retrieveAllMealsTest()      {
        final List<Meal> mockedMeals = this.mealService.getAllMeals();

        Assertions.assertNotNull(mockedMeals);
        Assertions.assertFalse(mockedMeals.isEmpty());
        Assertions.assertEquals(4, mockedMeals.size());
    }

    @Test
    public void shouldThrowExceptionWhenSearchingWithNullTest()     {
        NullPointerException thrownExceptionWhenNameNull = Assertions.assertThrows(
                NullPointerException.class, () -> this.mealService.getMealByName(null),
                "Name is null, and as expected, we throw an exception");
    }

    @Test
    public void shouldThrowExceptionWhenSearchingWithEmptyTest()     {
        NullPointerException thrownExceptionWhenNameNull = Assertions.assertThrows(
                NullPointerException.class, () -> this.mealService.getMealByName(""),
                "Name is empty, and as expected, we throw an exception");
    }

    @Test
    public void getMealByNameTest()     {
        final Meal namedMeal = this.mealService.getMealByName("Poulet braisé");

        Assertions.assertNotNull(namedMeal);
        Assertions.assertEquals(1, namedMeal.getId());

        final Meal unnamedMeal = this.mealService.getMealByName("Blanquette de Bouftou d'Alibert");
        Assertions.assertNull(unnamedMeal);
    }

    @Test
    public void getRandomMealTest()     {
        final Meal randomMeal = this.mealService.getRandomMeal();

        Assertions.assertNotNull(randomMeal);
    }
}
