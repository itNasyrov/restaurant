package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.Role;
import io.khasang.restaurant.entity.User;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RoleControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/role";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String GET_ID = "/get/id/";
    private final String DELETE = "/delete/";
    private final String ALL = "/all";


    @Test
    public void addRole() {
        Role role = createRole();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Role> responseEntity = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Role.class,
                role.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        Role resultRole = responseEntity.getBody();
        assertNotNull(resultRole);
        assertEquals(role.getName(), resultRole.getName());
    }

    @Test
    public void updateRole() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        RestTemplate restTemplate = new RestTemplate();
        Role role = createRole();

        role.setName("Customer");
        HttpEntity<Role> httpEntity = new HttpEntity<>(role, httpHeaders);

        User resultUpdatedRole = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                User.class).getBody();
        assertNotNull(resultUpdatedRole);
        assertNotNull(resultUpdatedRole.getId());
        assertEquals(role.getName(), resultUpdatedRole.getName());
    }

    @Test
    public void deleteRole() {
        Role role = createRole();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                role.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        ResponseEntity<Role> checkRoleExist = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Role.class,
                role.getId()
        );
        assertNull(checkRoleExist.getBody());
    }

    @Test
    public void getAllRoles() {
        RestTemplate restTemplate = new RestTemplate();
        createRole();
        createRole();

        ResponseEntity<List<Role>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Role>>() {
                }
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    private Role createRole()  {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Role role = rolePrefill();
        HttpEntity<Role> httpEntity = new HttpEntity<>(role, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Role result = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Role.class).getBody();
        assertNotNull(result);
        assertEquals("Deliveryman", result.getName());
        assertNotNull(result.getId());
        return result;

    }

    private Role rolePrefill() {
        Role role = new Role();
        role.setName("Deliveryman");

        User user = new User();
        user.setName("Dinar");
        user.setLogin(new String(String.valueOf(10)));

        User user2 = new User();
        user2.setName("Sergei");
        user2.setLogin(new String(String.valueOf(7)));

        List<User> userList = new ArrayList<>();

        userList.add(user);
        userList.add(user2);
        role.setUsers(userList);
        return role;
    }


}
