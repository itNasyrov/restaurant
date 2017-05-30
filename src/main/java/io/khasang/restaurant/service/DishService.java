package io.khasang.restaurant.service;

import io.khasang.restaurant.entity.Dish;

import java.util.List;

public interface DishService {

    /**
     * Create dish at database
     *
     * @param dish - dish for creation
     * @return dish
     */
    Dish addDish(Dish dish);

    /**
     * Receive all dish
     *
     * @return all dish from database
     */
    List<Dish> getDocumentList();

    /**
     * Delete specified dish by id
     *
     * @param id - id of dish for deleting
     * @return dish
     */
    Dish deleteDish(long id);

    /**
     * Receive dish by id
     *
     * @param id - id dish
     * @return dish
     */
    Dish getDishById(long id);

    /**
     * Dish update
     * @param dish - dish from request for update
     * @return dish
     */
    Dish updateDish(Dish dish);

    /**
     * Receive dish from database by name
     *
     * @param name - dish name
     * @return list of dish
     */
    List<Dish> getDishListById(String name);
}
