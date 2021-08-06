package com.badache.vigilanthappiness.entity;

import com.badache.vigilanthappiness.entity.enums.IngredientType;
import com.badache.vigilanthappiness.entity.enums.MealType;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateManyToManyMealIngredientsTest {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Test
    @Transactional
    public void shouldPersistData()   {
        final Set<Meal> mealsToPersist = new HashSet<>();

        final Meal pouletCoco = new Meal("Poulet coco", MealType.MIDI);
        final Meal raviolis = new Meal("Raviolis", MealType.SOIR);
        final Meal brunch = new Meal("Brunch", MealType.MATIN);

        mealsToPersist.add(pouletCoco);
        mealsToPersist.add(raviolis);

        final Ingredient poulet = new Ingredient("Escalope poulet", IngredientType.VIANDE);
        final Ingredient cremeCoco = new Ingredient("Creme coco", IngredientType.AUTRE);
        final Ingredient tomates = new Ingredient("Tomates", IngredientType.LEGUME);

        pouletCoco.addIngredient(poulet);
        pouletCoco.addIngredient(cremeCoco);

        raviolis.addIngredient(tomates);

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.persist(pouletCoco);
        entityManager.persist(raviolis);
    }

    @Test
    public void shouldMapManyToManyMealIngredients()    {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Ingredient> ingredients = entityManager.createQuery("FROM INGREDIENTS").getResultList();

        Assertions.assertNotNull(ingredients);
        for (Ingredient ing : ingredients)  {
            Assertions.assertNotNull(ing.getMeals());
            Assertions.assertTrue(ing.getMeals().size() >= 1);
        }
    }
}
