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
        final List<Meal> mockedMeals = mealService.getAllMeals();

        Assertions.assertNotNull(mockedMeals);
        Assertions.assertFalse(mockedMeals.isEmpty());
        Assertions.assertEquals(4, mockedMeals.size());
    }
}
