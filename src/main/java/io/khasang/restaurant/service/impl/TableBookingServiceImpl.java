package io.khasang.restaurant.service.impl;

import io.khasang.restaurant.dao.TableBookingDao;
import io.khasang.restaurant.entity.TableBooking;
import io.khasang.restaurant.service.TableBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service("tableBookingService")
public class TableBookingServiceImpl implements TableBookingService {
    @Autowired
    private TableBookingDao bookingDao;

    @Override
    public List<TableBooking> getAllTableBookings(Date bookTime) throws ParseException {
        return bookingDao.getAllTableBookings(bookTime);
    }

    @Override
    public int getAvailableTablesCount(Date bookTime) throws ParseException {
        return bookingDao.getAvailableTablesCount(bookTime);
    }

    @Override
    public TableBooking addBooking(TableBooking tableBooking) {
        return bookingDao.create(tableBooking);
    }

    @Override
    public TableBooking updateBooking(TableBooking tableBooking) {
        return bookingDao.update(tableBooking);
    }

    @Override
    public TableBooking deleteBooking(long id) {
        return bookingDao.delete(getBookingById(id));
    }

    @Override
    public TableBooking getBookingById(long id){
        return bookingDao.getById(id);
    }

}
