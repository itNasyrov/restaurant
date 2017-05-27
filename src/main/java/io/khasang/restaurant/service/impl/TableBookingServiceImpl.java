package io.khasang.restaurant.service.impl;

import io.khasang.restaurant.dao.TableBookingDao;
import io.khasang.restaurant.entity.RestaurantTable;
import io.khasang.restaurant.entity.TableBooking;
import io.khasang.restaurant.service.TableBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

/**
 * Created by firesome on 27.05.2017.
 */
@Service("tableBookingService")
public class TableBookingServiceImpl implements TableBookingService {
    @Autowired
    private TableBookingDao bookingDao;

    @Override
    public List<RestaurantTable> getAvailableTables(Calendar bookTime) {
        // todo: implement
        return null;
    }

    @Override
    public int getAvailableTablesCount(Calendar bookTime) {
        // todo: implement
        return -1;
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
