package io.khasang.restaurant.service;

import io.khasang.restaurant.entity.DishCategory;

import java.util.List;

public interface DishCategoryService {

    /**
     * Create category at database
     *
     * @param dishCategory - dish category for creation
     * @return dishCategory
     */
    DishCategory addDishCategory(DishCategory dishCategory);

    /**
     * Receive all dishCategory
     *
     * @return all dishCategory from database
     */
    List<DishCategory> getDishCategoryList();

    /**
     * Delete specified dishCategory by id
     *
     * @param id - id of dishCategory for deleting
     * @return dish
     */
    DishCategory deleteDishCategory(long id);

    /**
     * Receive dishCategory by id
     *
     * @param id - id dishCategory
     * @return dishCategory
     */
    DishCategory getDishCategoryById(long id);

    /**
     * {@link DishCategory} update
     * @param dishCategory - category from request for update
     * @return dishCategory
     */
    DishCategory updateDishCategory(DishCategory dishCategory);

    /**
     * Receive dishCategory from database by name
     *
     * @param name - dishCategory name
     * @return list of dishCategory
     */
    List<DishCategory> getDishCategoryList(String name);
}
