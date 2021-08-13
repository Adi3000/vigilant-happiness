package com.badache.vigilanthappiness.services.meal;

import com.badache.vigilanthappiness.dao.meal.IMealRepository;
import com.badache.vigilanthappiness.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    private IMealRepository mealRepository;

    public List<Meal> getAllMeals()     {
        return this.mealRepository.findAll();
    }
}
