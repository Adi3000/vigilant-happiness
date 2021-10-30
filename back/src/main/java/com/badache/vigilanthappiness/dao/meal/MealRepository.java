package com.badache.vigilanthappiness.dao.meal;

import com.badache.vigilanthappiness.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    /**
     * Self-explainatory: returns a meal by its name, assuming it is provided.
     * Throws a NullPointerException if the provided name is null or empty.
     * @param mealName The name of the meal (Meal.name in database)
     *
     * @return The meal entity, if a name matches. Null, otherwise.
     */
    @Query(value = "SELECT * FROM MEAL m WHERE m.name = ?1", nativeQuery = true)
    Meal getMealByName(final String mealName);

    @Query(value = "SELECT * FROM MEAL ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    Meal getRandomMeal();
}
