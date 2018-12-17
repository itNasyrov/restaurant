package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.Customer;
import io.khasang.restaurant.entity.RestaurantTable;
import io.khasang.restaurant.entity.TableBooking;
import io.khasang.restaurant.model.BookingStatus;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Customers and tables must exist in the database for tests to be passed
 */
@Ignore
public class TableBookingControllerIntegrationTest {

    //todo: extract constants to be used over the module
    private final String ROOT = "http://localhost:8080/booking";
    private final String GET_ALL_TABLE_BOOKINGS = "/all/date/{bookTime}" ;
    private final String GET_AVAILABLE_TABLES_COUNT = "/available/tables/date/{bookTime}";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete/id/{id}";
    private final String GET_BY_ID = "/get/id/{id}";

    private final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private final String strDate_1 = "2017-05-31 12:00:00";
    private final String strDate_2 = "2017-05-31 13:00:00";
    private final String strDate_3 = "2017-05-31 19:00:00";
    private final String strDate_4 = "2017-06-03 12:00:00";

    private Customer customer_1 = new Customer(1, "jack");
    private Customer customer_2 = new Customer(2, "john");
    private Customer customer_3 = new Customer(3, "jane");

    private RestaurantTable table_1 = new RestaurantTable(1, 4);
    private RestaurantTable table_2 = new RestaurantTable(2, 4);
    private RestaurantTable table_3 = new RestaurantTable(3, 5);
    private RestaurantTable table_4 = new RestaurantTable(4, 2);
    private RestaurantTable table_5 = new RestaurantTable(5, 2);

    private Date date_1;
    private Date date_2;
    private Date date_3;
    private Date date_4;

    private TableBooking booking_1;
    private TableBooking booking_2;
    private TableBooking booking_3;
    private TableBooking booking_4;
    private TableBooking booking_5;
    private TableBooking booking_6;


    @Before
    public void before() throws ParseException {
        date_1 = new SimpleDateFormat(DATE_TIME_PATTERN).parse(strDate_1);
        date_2 = new SimpleDateFormat(DATE_TIME_PATTERN).parse(strDate_2);
        date_3 = new SimpleDateFormat(DATE_TIME_PATTERN).parse(strDate_3);
        date_4 = new SimpleDateFormat(DATE_TIME_PATTERN).parse(strDate_4);
    }

    @Test
    public void getAllTableBookings() {
        List<RestaurantTable> list_1 = new ArrayList<>();
        list_1.add(table_1);

        List<RestaurantTable> list_2 = new ArrayList<>();
        list_2.add(table_4);

        List<RestaurantTable> list_3 = new ArrayList<>();
        list_3.add(table_2);

        List<RestaurantTable> list_4 = new ArrayList<>();
        list_4.add(table_1);
        list_4.add(table_2);
        list_4.add(table_5);

        booking_1 = addToDatabase(prefill(customer_1, list_1, date_1, BookingStatus.TABLE_BOOKED));
        booking_2 = addToDatabase(prefill(customer_2, list_2, date_1, BookingStatus.TABLE_BOOKED));
        booking_3 = addToDatabase(prefill(customer_3, list_3, date_2, BookingStatus.TABLE_BOOKED));
        booking_4 = addToDatabase(prefill(customer_1, list_1, date_4, BookingStatus.TABLE_BOOKED));
        booking_5 = addToDatabase(prefill(customer_3, list_4, date_3, BookingStatus.TABLE_BOOKED));
        booking_6 = addToDatabase(prefill(customer_1, list_3, date_2, BookingStatus.TABLE_BOOKED));

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<TableBooking>> responseEntity = restTemplate.exchange(
                ROOT + GET_ALL_TABLE_BOOKINGS,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<TableBooking>>() {
                },
                strDate_1
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        List<TableBooking> result = responseEntity.getBody();

        assertNotNull(result);
        assertEquals(5, result.size());

        removeListFromDatabase();
    }

    @Test
    public void getAvailableTablesCount() {
        List<RestaurantTable> list_1 = new ArrayList<>();
        list_1.add(table_1);

        List<RestaurantTable> list_2 = new ArrayList<>();
        list_2.add(table_4);

        List<RestaurantTable> list_3 = new ArrayList<>();
        list_3.add(table_2);

        List<RestaurantTable> list_4 = new ArrayList<>();
        list_4.add(table_1);
        list_4.add(table_2);
        list_4.add(table_5);

        booking_1 = addToDatabase(prefill(customer_1, list_1, date_1, BookingStatus.TABLE_OPENED));
        booking_2 = addToDatabase(prefill(customer_2, list_2, date_1, BookingStatus.TABLE_CLOSED));
        booking_3 = addToDatabase(prefill(customer_3, list_3, date_2, BookingStatus.TABLE_CANCELLED));
        booking_4 = addToDatabase(prefill(customer_1, list_1, date_4, BookingStatus.TABLE_BOOKED));
        booking_5 = addToDatabase(prefill(customer_3, list_4, date_3, BookingStatus.TABLE_BOOKED));
        booking_6 = addToDatabase(prefill(customer_1, list_3, date_2, BookingStatus.TABLE_BOOKED));

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Integer> responseEntity = restTemplate.exchange(
                ROOT + GET_AVAILABLE_TABLES_COUNT,
                HttpMethod.GET,
                null,
                Integer.class,
                strDate_1
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        int result = responseEntity.getBody();
        assertEquals(2, result);

        removeListFromDatabase();
    }

    @Test
    public void test_CRUD() throws ParseException {
        TableBooking booking = prefill();

        // CREATE
        TableBooking result = addToDatabase(booking);

        assertNotNull(result);

        long id = result.getId();
        assertTrue(id > 0);

        // READ
        result = getFromDatabase(id);

        assertNotNull(result);

        assertNotNull(result.getCustomer());
        assertEquals(booking.getCustomer().getId(), result.getCustomer().getId());
        assertEquals(booking.getCustomer().getName(), result.getCustomer().getName());

        assertNotNull(result.getTables());
        assertEquals(result.getTables().size(), 3);

        assertNotNull(booking.getTables().get(0));
        assertEquals(booking.getTables().get(0).getId(), result.getTables().get(0).getId());
        assertEquals(booking.getTables().get(0).getCapacity(), result.getTables().get(0).getCapacity());

        assertNotNull(booking.getTables().get(1));
        assertEquals(booking.getTables().get(1).getId(), result.getTables().get(1).getId());
        assertEquals(booking.getTables().get(1).getCapacity(), result.getTables().get(1).getCapacity());

        assertNotNull(booking.getTables().get(2));
        assertEquals(booking.getTables().get(2).getId(), result.getTables().get(2).getId());
        assertEquals(booking.getTables().get(2).getCapacity(), result.getTables().get(2).getCapacity());


        assertEquals(booking.getBookTime(), result.getBookTime());
        assertEquals(booking.getStatus(), result.getStatus());

        // UPDATE
        Date oldDate = booking.getBookTime();
        Date newDate = new Date();
        booking.setBookTime(newDate);

        BookingStatus oldStatus = booking.getStatus();
        booking.setStatus(BookingStatus.TABLE_CANCELLED);
        booking.setId(result.getId());

        result = updateInDatabase(booking);

        assertNotNull(result);

        assertNotEquals(oldDate, result.getBookTime());
        assertEquals(newDate, result.getBookTime());

        assertNotEquals(oldStatus, result.getStatus());
        assertEquals(BookingStatus.TABLE_CANCELLED, result.getStatus());

        // DELETE
        deleteFromDatabase(id);
        assertNull(getFromDatabase(id));
    }

    private TableBooking prefill(Customer customer, List<RestaurantTable> tables, Date bookTime, BookingStatus status) {
        TableBooking result = new TableBooking();
        result.setCustomer(customer);
        result.setTables(tables);
        result.setBookTime(bookTime);
        result.setStatus(status);
        return result;
    }

    private TableBooking prefill() throws ParseException {
        List<RestaurantTable> tables = new ArrayList<>();
        tables.add(table_1);
        tables.add(table_3);
        tables.add(table_5);

        return prefill(customer_3, tables, date_3, BookingStatus.TABLE_BOOKED);
    }

    private TableBooking addToDatabase(TableBooking booking) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<TableBooking> httpEntity = new HttpEntity<>(booking, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();

        assertTrue(booking.getId() == 0);

        ResponseEntity<TableBooking> responseEntity = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                TableBooking.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        return responseEntity.getBody();
    }

    private TableBooking deleteFromDatabase(long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TableBooking> responseEntity = restTemplate.exchange(
                ROOT + DELETE,
                HttpMethod.DELETE,
                null,
                TableBooking.class,
                id
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        return responseEntity.getBody();
    }

    private TableBooking updateInDatabase(TableBooking booking) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<TableBooking> httpEntity = new HttpEntity<>(booking, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<TableBooking> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                TableBooking.class
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        return responseEntity.getBody();
    }

    private TableBooking getFromDatabase(long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TableBooking> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID,
                HttpMethod.GET,
                null,
                TableBooking.class,
                id
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        return responseEntity.getBody();
    }

    private void removeListFromDatabase() {
        deleteFromDatabase(booking_1.getId());
        deleteFromDatabase(booking_2.getId());
        deleteFromDatabase(booking_3.getId());
        deleteFromDatabase(booking_4.getId());
        deleteFromDatabase(booking_5.getId());
        deleteFromDatabase(booking_6.getId());
    }
}
