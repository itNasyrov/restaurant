package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.Booking;
import io.khasang.restaurant.entity.Event;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.math.BigDecimal;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class BookingControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/booking";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String GET_ID = "/get/id/";
    private final String DELETE = "/delete/";
    private final String ALL = "/all";
    private final String EVENT_ADD = "http://localhost:8080/event/add";

    @Test
    public void addBooking() {
        Booking booking = createBooking();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Booking> responseEntity = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Booking.class,
                booking.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        Booking resultBooking = responseEntity.getBody();
        assertNotNull(resultBooking);
        assertEquals(booking.getPhone(), resultBooking.getPhone());
    }

    @Test
    public void updateBooking(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        RestTemplate restTemplate = new RestTemplate();
        Booking booking = createBooking();

        booking.setPhone("54321");
        HttpEntity<Booking> httpEntity = new HttpEntity<>(booking, httpHeaders);

        Booking resultUpdatedBooking = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Booking.class).getBody();
        assertNotNull(resultUpdatedBooking);
        assertNotNull(resultUpdatedBooking.getId());
        assertEquals(booking.getPhone(), resultUpdatedBooking.getPhone());
    }

    @Test
    public void deleteBooking(){
        Booking booking = createBooking();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                booking.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        ResponseEntity<Booking> checkBookingExist = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                Booking.class,
                booking.getId()
        );

        assertNull(checkBookingExist.getBody());
    }

    @Test
    public void getAllBookings(){
        RestTemplate restTemplate = new RestTemplate();
        createBooking();
        createBooking();

        ResponseEntity<List<Booking>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Booking>>() {
                }
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
    }

    private Booking createBooking() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Event event = createEvent();

        Booking booking = bookingPrefill();
        booking.setEvent(event);

        HttpEntity<Booking> httpEntity = new HttpEntity<>(booking, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Booking result = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Booking.class).getBody();
        assertNotNull(result);
        assertEquals("12345", result.getPhone());
        assertNotNull(result.getId());
        return result;
    }

    private Booking bookingPrefill() {
        Booking booking = new Booking();
        booking.setPhone("12345");
        return booking;
    }

    private Event eventPrefill() {
        Event event = new Event();
        event.setName("Birthday");
        event.setPrice(new BigDecimal(10000.20));
        return event;
    }

    private Event createEvent() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        RestTemplate restTemplate = new RestTemplate();

        Event event = eventPrefill();
        HttpEntity<Event> httpEvent = new HttpEntity<>(event, httpHeaders);

        Event resultEvent = restTemplate.exchange(
                EVENT_ADD,
                HttpMethod.PUT,
                httpEvent,
                Event.class).getBody();
        return resultEvent;
    }
}
