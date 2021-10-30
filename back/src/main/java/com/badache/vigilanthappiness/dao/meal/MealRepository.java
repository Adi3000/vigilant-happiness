package com.badache.vigilanthappiness.dao.meal;

import com.badache.vigilanthappiness.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

    @Query(value = "SELECT * FROM MEAL m WHERE m.name = ?1", nativeQuery = true)
    public Meal getMealByName(final String mealName);
}
