package io.khasang.restaurant.dao;

import io.khasang.restaurant.entity.Dish;

import java.util.List;

public interface DishDao extends BasicDao<Dish> {

    /**
     * Create dish at database
     *
     * @param dish - dish
     * @return dish
     */
    Dish addDish(Dish dish);

    List<Dish> findByName(String name);
}
