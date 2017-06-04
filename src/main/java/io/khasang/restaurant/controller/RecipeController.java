package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.Recipe;
import io.khasang.restaurant.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Recipe addRecipe(@RequestBody Recipe recipe){
        return recipeService.addRecipe(recipe);
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Recipe> getRecipeList(){
        return recipeService.getRecipeList();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Recipe deleteRecipe(@PathVariable(value = "id") String id) {
        return recipeService.deleteRecipe(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Recipe getRecipeById(@PathVariable(value = "id") String id) {
        return recipeService.getRecipeById(Long.parseLong(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Recipe updateRecipe(@RequestBody Recipe recipe) {
        recipeService.updateRecipe(recipe);
        return recipe;
    }

    @RequestMapping(value = "/get/text/{text}", method = RequestMethod.GET)
    @ResponseBody
    public List<Recipe> getRecipeListById(@PathVariable(value = "text") String text) {
        return recipeService.getRecipeListByText(text);
    }
}
