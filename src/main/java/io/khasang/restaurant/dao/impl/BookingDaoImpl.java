package io.khasang.restaurant.dao.impl;

import io.khasang.restaurant.dao.BookingDao;
import io.khasang.restaurant.entity.Booking;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BookingDaoImpl extends BasicDaoImpl<Booking> implements BookingDao{
    @Autowired
    private SessionFactory sessionFactory;

    public BookingDaoImpl(Class<Booking> entityClass){
        super(entityClass);
    }

    @Override
    public Booking create(Booking entity) {
        return null;
    }

    @Override
    public Booking addBooking(Booking booking) {
        sessionFactory.getCurrentSession().save(booking);
        return booking;
    }


}
