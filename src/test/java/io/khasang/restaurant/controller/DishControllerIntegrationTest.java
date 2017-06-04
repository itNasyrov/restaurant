package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.Dish;
import io.khasang.restaurant.entity.DishCategory;
import io.khasang.restaurant.entity.Recipe;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class DishControllerIntegrationTest {
    private final String ROOT_DISH = "http://localhost:8080/dish";
    private final String ROOT_CATEGORY = "http://localhost:8080/dishcategory";
    private final String ROOT_RECIPE = "http://localhost:8080/recipe";

    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String GET_ID = "/get/id/";
    private final String GET_NAME = "/get/name/";
    private final String DELETE = "/delete/";
    private final String ALL = "/all";

    @Test
    public void addDish() {
        Dish dish = createTestObjects();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Dish> responseEntity = restTemplate.exchange(
                ROOT_DISH + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Dish.class,
                dish.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Dish result = responseEntity.getBody();
        assertNotNull(result);
        assertEquals(dish.getComment(), result.getComment());
    }

    @Test
    @Transactional
    public void updateDocument(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        RestTemplate restTemplate = new RestTemplate();
        Dish dish = createTestObjects();

        dish.setName("Dressed herring");
        dish.setComment("Layered salad composed of diced pickled herring covered with layers of grated boiled " +
                "vegetables (potatoes, carrots, beet roots), chopped onions, and mayonnaise");

        HttpEntity<Dish> httpEntity = new HttpEntity<>(dish, httpHeaders);

        Dish result = restTemplate.exchange(
                ROOT_DISH + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Dish.class).getBody();
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(dish.getName(), result.getName());
        assertEquals(dish.getComment(), result.getComment());
    }

    @Test
    @Transactional
    public void deleteDish() {
        Dish dish = createTestObjects();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT_DISH + DELETE + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                dish.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        ResponseEntity<Dish> checkDishExist = restTemplate.exchange(
                ROOT_DISH + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Dish.class,
                dish.getId()
        );
        assertNull(checkDishExist.getBody());
    }

    @Test
    @Transactional
    public void getAllDishs(){
        RestTemplate restTemplate = new RestTemplate();

        Dish dish1 = createTestObjects();
        Dish dish2 = createTestObjects();

        ResponseEntity<List<Dish>> responseEntity = restTemplate.exchange(
                ROOT_DISH + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Dish>>() {
                }
        );

        List<Dish> list = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    private Dish createTestObjects() {
        DishCategory category = createDishCategory();
        Dish dish = createDish(category);
        Recipe recipe = createRecipe(dish);
        return dish;
    }

    private DishCategory createDishCategory() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        DishCategory category = dishCategoryPrefill();
        HttpEntity<DishCategory> httpEntity = new HttpEntity<>(category, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        DishCategory result = restTemplate.exchange(
                ROOT_CATEGORY + ADD,
                HttpMethod.PUT,
                httpEntity,
                DishCategory.class).getBody();
        assertNotNull(result);
        assertEquals("Salads", result.getName());
        return result;
    }

    private DishCategory dishCategoryPrefill() {
        DishCategory dishCategory = new DishCategory();
        dishCategory.setName("Salads");
        return dishCategory;
    }

    private Dish createDish(DishCategory dishCategory) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Dish dish = dishPrefill(dishCategory);
        HttpEntity<Dish> httpEntity = new HttpEntity<>(dish, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Dish result = restTemplate.exchange(
                ROOT_DISH + ADD,
                HttpMethod.PUT,
                httpEntity,
                Dish.class).getBody();
        assertNotNull(result);
        assertEquals("Salad Olivier", result.getName());
        return result;
    }

    private Dish dishPrefill(DishCategory dishCategory) {
        Dish dish = new Dish();
        dish.setName("Salad Olivier");
        dish.setComment("traditional salad dish in Russian cuisine, which is also popular in many other European " +
                "countries, Iran, Israel, Mongolia and also throughout Latin America");
        dish.setRealizationTimeHours(24);
        dish.setCategory(dishCategory);
        return dish;
    }

    private Recipe createRecipe(Dish dishForRecipe) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Recipe recipe = recipePrefill(dishForRecipe);
        HttpEntity<Recipe> httpEntity = new HttpEntity<>(recipe, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Recipe result = restTemplate.exchange(
                ROOT_RECIPE + ADD,
                HttpMethod.PUT,
                httpEntity,
                Recipe.class).getBody();
        assertNotNull(result);
        return result;
    }

    private Recipe recipePrefill(Dish dishForRecipe) {
        Recipe recipe = new Recipe();
        recipe.setDish(dishForRecipe);
        recipe.setProteins(6);
        recipe.setFats(11.57f);
        recipe.setCarbohydrates(11.35f);
        recipe.setEnergyValue(172);
        recipe.setServingGram(100);
        recipe.setTimeCookingMinutes(60);
        recipe.setRecipeText("Ingredients\n" +
                "\n" +
                "2 large eggs\n" +
                "6 tablespoons water, divided\n" +
                "12 ounces small Yukon gold potatoes, halved\n" +
                "1/4 cup canola mayonnaise\n" +
                "2 tablespoons pickle relish\n" +
                "1 teaspoon sugar\n" +
                "1 teaspoon black pepper\n" +
                "1 teaspoon Dijon mustard" +
                "How to Make It\n" +
                "\n" +
                "Place eggs in a small saucepan; fill with water to cover eggs. Bring to a boil. Remove pan from heat; " +
                "cover and let stand 10 minutes. Plunge eggs into ice water; drain. Peel and coarsely chop eggs.\n" +
                "Place 3 tablespoons water and potatoes in a microwave-safe bowl; cover tightly with plastic wrap. " +
                "Pierce plastic wrap once with a fork. Microwave at HIGH 7 minutes or until tender. Uncover and " +
                "refrigerate 10 minutes or until cool.\n" +
                "Combine eggs, remaining 3 tablespoons water, potatoes, and remaining ingredients in a medium bowl, " +
                "breaking up potatoes with a spoon.");
        return recipe;
    }
}
