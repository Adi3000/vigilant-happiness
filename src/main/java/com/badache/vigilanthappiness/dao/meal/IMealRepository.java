package com.badache.vigilanthappiness.dao.meal;

import com.badache.vigilanthappiness.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMealRepository extends JpaRepository<Meal, Long> {

}
