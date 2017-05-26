package io.khasang.restaurant.dao;

import io.khasang.restaurant.entity.Booking;

public interface BookingDao extends BasicDao<Booking>{

    /**
     * Create booking at database
     * @param booking - booking
     * @return booking
     */
    Booking addBooking(Booking booking);


}
