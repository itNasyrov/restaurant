package io.khasang.restaurant.service;

import io.khasang.restaurant.entity.Booking;

import java.sql.Timestamp;
import java.util.List;

public interface BookingService {

    /**
     * Create booking at database
     * @param booking - booking for creation
     * @return booking
     */
    Booking addBooking(Booking booking);
    /**
     *Receive all documents
     *
     * @return all documents from database
     */
    List<Booking> getBookingList();

    /**
     * Update booking
     * @param booking - booking from request for update
     * @return booking
     */
    Booking updateBooking(Booking booking);

    /**
     * Delete booking from table
     * @param id - id
     * @return
     */
    Booking deleteBooking(long id);

    /**
     * Receive booking list by id
     * @param id - id booking list
     * @return booking list
     */
    Booking getBookingById(long id);

    /**
     * Receive booking list by name
     * @param name - clients name
     * @return clients booking list
     */
    List<Booking> getBookingByName(String name);
}
