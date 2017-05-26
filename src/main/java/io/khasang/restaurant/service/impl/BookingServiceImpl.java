package io.khasang.restaurant.service.impl;

import io.khasang.restaurant.dao.BookingDao;
import io.khasang.restaurant.entity.Booking;
import io.khasang.restaurant.service.BookingService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Session getCurrentSession() {
        return null;
    }

    @Override
    public Booking create(Booking entity) {
        return null;
    }

    @Override
    public List<Booking> getList() {
        return null;
    }

    @Override
    public Booking getById(long id) {
        return null;
    }

    @Override
    public Booking delete(Booking entity) {
        return null;
    }

    @Override
    public Booking update(Booking entity) {
        return null;
    }
}
