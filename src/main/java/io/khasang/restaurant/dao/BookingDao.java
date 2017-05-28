package io.khasang.restaurant.dao;

import io.khasang.restaurant.entity.Booking;

import java.util.List;

public interface BookingDao extends BasicDao<Booking>{

    /**
     * Create booking at database
     * @param booking - booking
     * @return booking
     */
    Booking addBooking(Booking booking);


    /**
     * Find booking list by clients name
     * @param name - clients name
     * @return clients list
     */
    List<Booking> getByName(String name);
}
