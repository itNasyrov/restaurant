package io.khasang.restaurant.dao;

import io.khasang.restaurant.entity.Booking;

import java.util.Date;
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


    /**
     * Receive bookings for the period
     *
     * @param dateBegin - begin date of period
     * @param dateEnd - end date of period
     * @return bookings list
     */
    List<Booking> getForPeriod(Date dateBegin, Date dateEnd);

    /**
     * Booking availability check
     *
     * @param dateBegin - begin date of period
     * @param dateEnd - end date of period
     * @return flag is true, if booking is available
     */
    Boolean isBookingAvailable(Date dateBegin, Date dateEnd);
}
