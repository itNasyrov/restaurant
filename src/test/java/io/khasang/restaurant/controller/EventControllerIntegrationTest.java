package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.Booking;
import io.khasang.restaurant.entity.Event;

import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class EventControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/event";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String GET_ID = "/get/id/";
    private final String DELETE = "/delete/";
    private final String ALL = "/all";


    @Test
    public void addEvent() {
        Event event = createEvent();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Event> responseEntity = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Event.class,
                event.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        Event resultEvent = responseEntity.getBody();
        assertNotNull(resultEvent);
        assertEquals(event.getDescription(), resultEvent.getDescription());
    }

    @Test
    public void updateEvent() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        RestTemplate restTemplate = new RestTemplate();
        Event event = createEvent();

        event.setName("Birthday");
        HttpEntity<Event> httpEntity = new HttpEntity<>(event, httpHeaders);

        Event resultUpdatedDocument = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Event.class).getBody();
        assertNotNull(resultUpdatedDocument);
        assertNotNull(resultUpdatedDocument.getId());
        assertEquals(event.getName(), resultUpdatedDocument.getName());
    }

    @Test
    public void deleteEvent() {
        Event event = createEvent();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                event.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        ResponseEntity<Event> checkDocumentExist = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Event.class,
                event.getId()
        );
        assertNull(checkDocumentExist.getBody());
    }

    @Test
    public void getAllEvents() {
        RestTemplate restTemplate = new RestTemplate();
        createEvent();
        createEvent();

        ResponseEntity<List<Event>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Event>>() {
                }
        );
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    private Event createEvent() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Event event = eventPrefill();
        HttpEntity<Event> httpEntity = new HttpEntity<>(event, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Event result = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Event.class).getBody();
        assertNotNull(result);
        assertEquals("Marriage", result.getName());
        assertEquals("Golden", result.getDescription());
        assertNotNull(result.getId());
        return result;
    }

    private Event eventPrefill() {
        Event event = new Event();
        event.setName("Marriage");
        event.setDescription("Golden");

        Booking booking = new Booking();
        booking.setClient("Dinar");
        booking.setPriceOfEventAndMenu(new Double(Double.valueOf(10)));

        Booking booking2 = new Booking();
        booking2.setClient("Sergei");
        booking2.setPriceOfEventAndMenu(new Double(Double.valueOf(8)));

        List<Booking> bookingList = new ArrayList<>();
        bookingList.add(booking);
        bookingList.add(booking2);

        event.setBookings(bookingList);
        return event;



    }



}