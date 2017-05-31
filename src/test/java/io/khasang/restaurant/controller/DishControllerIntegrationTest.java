package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.Dish;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class DishControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/dish";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String GET_ID = "/get/id/";
    private final String GET_NAME = "/get/name/";
    private final String DELETE = "/delete/";
    private final String ALL = "/all";

    @Test
    public void addDish() {
        Dish dish = createDish();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Dish> responseEntity = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
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
    public void updateDocument(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        RestTemplate restTemplate = new RestTemplate();
        Dish dish = createDish();

        dish.setName("Dressed herring");
        dish.setComment("Layered salad composed of diced pickled herring covered with layers of grated boiled " +
                "vegetables (potatoes, carrots, beet roots), chopped onions, and mayonnaise");

        HttpEntity<Dish> httpEntity = new HttpEntity<>(dish, httpHeaders);

        Dish result = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Dish.class).getBody();
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(dish.getName(), result.getName());
        assertEquals(dish.getComment(), result.getComment());
    }

    @Test
    public void deleteDish() {
        Dish dish = createDish();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                dish.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        ResponseEntity<Dish> checkDishExist = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Dish.class,
                dish.getId()
        );
        assertNull(checkDishExist.getBody());
    }

    @Test
    public void getAllDishs(){
        RestTemplate restTemplate = new RestTemplate();

        Dish dish1 = createDish();
        Dish dish2 = createDish();

        ResponseEntity<List<Dish>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Dish>>() {
                }
        );

        List<Dish> list = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    private Dish createDish() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Dish dish = dishPrefill();
        HttpEntity<Dish> httpEntity = new HttpEntity<>(dish, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Dish result = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Dish.class).getBody();
        assertNotNull(result);
        assertEquals("Salad Olivier", result.getName());
        assertNotNull(result.getId());
        return result;
    }

    private Dish dishPrefill() {
        Dish dish = new Dish();
        dish.setName("Salad Olivier");
        dish.setComment("traditional salad dish in Russian cuisine, which is also popular in many other European " +
                "countries, Iran, Israel, Mongolia and also throughout Latin America");
        dish.setRealizationTime(24);
        return dish;
    }
}
