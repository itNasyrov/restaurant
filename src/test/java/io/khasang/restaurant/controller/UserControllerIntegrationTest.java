package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.User;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/user";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String GET_ID = "/get/id/";
    private final String DELETE = "/delete/";
    private final String ALL = "/all";


    @Test
    public void addUser() {
        User user = createUser();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<User> responseEntity = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                User.class,
                user.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        User resultUser = responseEntity.getBody();
        assertNotNull(resultUser);
        assertEquals(user.getLogin(), resultUser.getLogin());
    }

    @Test
    public void updateUser() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        RestTemplate restTemplate = new RestTemplate();
        User user = createUser();

        user.setName("Ivan");
        HttpEntity<User> httpEntity = new HttpEntity<>(user, httpHeaders);

        User resultUpdatedUser = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                User.class).getBody();
        assertNotNull(resultUpdatedUser);
        assertNotNull(resultUpdatedUser.getId());
        assertEquals(user.getName(), resultUpdatedUser.getName());
    }

    @Test
    public void deleteUser() {
        User user = createUser();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                user.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        ResponseEntity<User> checkUserExist = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                User.class,
                user.getId()
        );
        assertNull(checkUserExist.getBody());
    }

    @Test
    public void getAllUsers() {
        RestTemplate restTemplate = new RestTemplate();
        createUser();
        createUser();

        ResponseEntity<List<User>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                }
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    private User createUser()  {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
            User user = userPrefill();
            HttpEntity<User> httpEntity = new HttpEntity<>(user, httpHeaders);
            RestTemplate restTemplate = new RestTemplate();
            User result = restTemplate.exchange(
                    ROOT + ADD,
                    HttpMethod.PUT,
                    httpEntity,
                    User.class).getBody();
        assertNotNull(result);
        assertEquals("Dinar", result.getName());
        assertEquals("Devotee", result.getLogin());
        assertNotNull(result.getId());
            return result;

    }

    private User userPrefill() {
        User user = new User();
        user.setName("Dinar");
        user.setLogin("Devotee");
        return user;
    }

}
