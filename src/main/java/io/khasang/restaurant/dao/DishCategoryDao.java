package io.khasang.restaurant.dao;

import io.khasang.restaurant.entity.DishCategory;

import java.util.List;

public interface DishCategoryDao extends BasicDao<DishCategory> {

    /**
     * Create dish category at database
     *
     * @param dishCategory
     * @return dishCategory
     */
    DishCategory addDishCategory(DishCategory dishCategory);

    List<DishCategory> findByName(String name);
}
