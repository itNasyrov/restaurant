package io.khasang.restaurant.service.impl;

import io.khasang.restaurant.dao.BookingDao;
import io.khasang.restaurant.entity.Booking;
import io.khasang.restaurant.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service("bookingService")
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDao bookingDao;

    @Override
    public Booking addBooking(Booking booking) {
        return bookingDao.addBooking(booking);
    }

    @Override
    public Booking updateBooking(Booking booking) {
        return bookingDao.update(booking);
    }

    @Override
    public List<Booking> getBookingList() {
        return bookingDao.getList();
    }

    @Override
    public Booking deleteBooking(long id) {
        return bookingDao.delete(getBookingById(id));
    }

    @Override
    public Booking getBookingById(long id) {
        return bookingDao.getById(id);
    }

    @Override
    public List<Booking> getBookingByName(String name) {
        return bookingDao.getByName(name);
    }

    @Override
    public List<Booking> getForPeriod(Date dateBegin, Date dateEnd) {
        return bookingDao.getForPeriod(dateBegin, dateEnd);
    }

    @Override
    public Boolean isBookingAvailable(Date dateBegin, Date dateEnd) {
        return bookingDao.isBookingAvailable(dateBegin, dateEnd);
    }
}
