package io.khasang.reataurant.controller;

import io.khasang.restaurant.entity.Firm;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class FirmControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/firm";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String GET_ID = "/get/id/";
    private final String DELETE = "/delete/";
    private final String ALL = "/all";


    @Test
    public void addFirm() {
        Firm firm = createFirm();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Firm> responseEntity = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Firm.class,
                firm.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        Firm resultFirm = responseEntity.getBody();
        assertNotNull(resultFirm);
        assertEquals(firm.getDescription(), resultFirm.getDescription());
    }

    @Test
    public void updateFirm(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        RestTemplate restTemplate = new RestTemplate();
        Firm firm =  createFirm();

        firm.setName("IceArrow");
        HttpEntity<Firm> httpEntity = new HttpEntity<>(firm, httpHeaders);

        Firm resultUpdatedFirm = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Firm.class).getBody();
        assertNotNull(resultUpdatedFirm);
        assertNotNull(resultUpdatedFirm.getId());
        assertEquals(firm.getName(), resultUpdatedFirm.getName());
    }

    @Test
    public void deleteFirm(){
        Firm firm = createFirm();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                firm.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        ResponseEntity<Firm> checkFirmExist = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Firm.class,
                firm.getId()
        );

        assertNull(checkFirmExist.getBody());
    }

    @Test
    public void getAllFirms(){
        RestTemplate restTemplate = new RestTemplate();
        createFirm();
        createFirm();

        ResponseEntity<List<Firm>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Firm>>() {
                }
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    private Firm createFirm() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Firm firm = firmPrefill();
        HttpEntity<Firm> httpEntity = new HttpEntity<>(firm, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Firm result = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Firm.class).getBody();
        assertNotNull(result);
        assertEquals("Fireball", result.getName());
        assertNotNull(result.getId());
        return result;
    }

    private Firm firmPrefill() {
        Firm firm = new Firm();
        firm.setName("Fireball");
        firm.setDescription("Medium size");
        return firm;
    }


}

