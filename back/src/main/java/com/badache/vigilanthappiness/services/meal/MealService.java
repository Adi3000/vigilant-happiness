package com.badache.vigilanthappiness.services.meal;

import com.badache.vigilanthappiness.dao.meal.MealRepository;
import com.badache.vigilanthappiness.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public List<Meal> getAllMeals()     {
        return this.mealRepository.findAll();
    }

    public Meal getMealByName(final String mealName)       {
        if (!StringUtils.hasLength(mealName))     {
            throw new NullPointerException("Meal name cannot be empty");
        }

        return this.mealRepository.getMealByName(mealName);
    }
}
