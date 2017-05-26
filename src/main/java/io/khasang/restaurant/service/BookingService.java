package io.khasang.restaurant.service;

import io.khasang.restaurant.dao.BasicDao;
import io.khasang.restaurant.entity.Booking;

public interface BookingService extends BasicDao<Booking>{

    /**
     * Create booking at database
     * @param booking - booking for creation
     * @return booking
     */
    Booking addBooking(Booking booking);
}
