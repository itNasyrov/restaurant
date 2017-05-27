package io.khasang.restaurant.service;

import io.khasang.restaurant.entity.RestaurantTable;
import io.khasang.restaurant.entity.TableBooking;

import java.util.Calendar;
import java.util.List;

/**
 * Created by firesome on 27.05.2017.
 */
public interface TableBookingService {

    /**
     * Gets list of tables available for the specified date/time
     * @param bookTime - Date/time to make a snapshot of available tables
     * @return List of tables available for the specified date/time
     */
    List<RestaurantTable> getAvailableTables(Calendar bookTime);

    /**
     * Gets number of tables available for the specified date/time
     * @param bookTime - Date/time to make a snapshot of available tables
     * @return Number of tables available for the specified date/time
     */
    int getAvailableTablesCount(Calendar bookTime);

    /**
     * Creates table booking
     * @param tableBooking - Table booking to be created
     * @return Table booking created
     */
    TableBooking addBooking(TableBooking tableBooking);

    /**
     * Updates table booking
     * @param tableBooking - Table to be updated
     * @return Table booking updated
     */
    TableBooking updateBooking(TableBooking tableBooking);

    /**
     * Deletes table booking
     * @param id - Id of the table booking to be deleted
     * @return Table booking deleted
     */
    TableBooking deleteBooking(long id);

    /**
     * Gets table booking by id
     * @param id - Id of the table booking to be taken
     * @return Table booking taken
     */
    TableBooking getBookingById(long id);

}
