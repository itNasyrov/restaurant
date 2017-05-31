package io.khasang.restaurant.service.impl;

import io.khasang.restaurant.dao.RecipeDao;
import io.khasang.restaurant.entity.Dish;
import io.khasang.restaurant.entity.Recipe;
import io.khasang.restaurant.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("recipeService")
public class RecipeServiceImpl implements RecipeService {
    @Autowired
    private RecipeDao recipeDao;

    @Override
    public Recipe addRecipe(Recipe recipe) {
        return recipeDao.addRecipe(recipe);
    }

    @Override
    public List<Recipe> getRecipeList() {
        return recipeDao.getList();
    }

    @Override
    public Recipe deleteRecipe(long id) {
        return recipeDao.delete(getRecipeById(id));
    }

    @Override
    public Recipe getRecipeById(long id) {
        return recipeDao.getById(id);
    }

    @Override
    public Recipe updateRecipe(Recipe recipe) {
        return recipeDao.update(recipe);
    }

    @Override
    public List<Recipe> getRecipeListById(String name) {
        return recipeDao.findByName(name);
    }


}
