package io.khasang.restaurant.dao;

import io.khasang.restaurant.entity.Recipe;

import java.util.List;

public interface RecipeDao extends BasicDao<Recipe> {

    /**
     * Create Recipe at database
     *
     * @param recipe - Recipe
     * @return dish
     */
    Recipe addRecipe(Recipe recipe);

    List<Recipe> findByText(String text);
}
