package io.khasang.restaurant.dao;

import io.khasang.restaurant.entity.TableBooking;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface TableBookingDao extends BasicDao<TableBooking> {

    List<TableBooking> getAllTableBookings(Date bookTime) throws ParseException;

    int getAvailableTablesCount(Date bookTime) throws ParseException;

}
