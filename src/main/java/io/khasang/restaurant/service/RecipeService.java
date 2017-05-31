package io.khasang.restaurant.service;

import io.khasang.restaurant.entity.Recipe;

import java.util.List;

public interface RecipeService {

    /**
     * Create Recipe at database
     *
     * @param recipe - Recipe for creation
     * @return Recipe
     */
    Recipe addRecipe(Recipe recipe);

    /**
     * Receive all Recipe
     *
     * @return all Recipe from database
     */
    List<Recipe> getRecipeList();

    /**
     * Delete specified Recipe by id
     *
     * @param id - id of Recipe for deleting
     * @return Recipe
     */
    Recipe deleteRecipe(long id);

    /**
     * Receive Recipe by id
     *
     * @param id - id Recipe
     * @return Recipe
     */
    Recipe getRecipeById(long id);

    /**
     * Recipe update
     * @param recipe - Recipe from request for update
     * @return Recipe
     */
    Recipe updateRecipe(Recipe recipe);

    /**
     * Receive Recipe from database by name
     *
     * @param name - Recipe name
     * @return list of Recipe
     */
    List<Recipe> getRecipeListById(String name);
}
