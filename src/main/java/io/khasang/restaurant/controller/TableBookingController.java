package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.BookingStatus;
import io.khasang.restaurant.entity.Customer;
import io.khasang.restaurant.entity.RestaurantTable;
import io.khasang.restaurant.entity.TableBooking;
import io.khasang.restaurant.service.TableBookingService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Calendar;
import java.util.List;

/**
 * Created by firesome on 27.05.2017.
 */
public class TableBookingController {
    @Autowired
    private TableBookingService tableBookingService;

    /**
     * Get list of tables available for the specified date/time
     * @param bookTime - Date/time to make a snapshot of available tables
     * @return List of tables available for the specified date/time
     */
    // todo: RequestMapping and stuff. Probably Calendar will turn into something else
    public List<RestaurantTable> getAvailableTables(Calendar bookTime) {
        // todo: implement. Test first!
        return null;
    }

    /**
     * Get number of tables available for the specified date/time
     * @param bookTime - Date/time to make a snapshot of available tables
     * @return Number of tables available for the specified date/time
     */
    // todo: RequestMapping and stuff. Probably Calendar will turn into something else
    public int getAvailableTablesCount(Calendar bookTime) {
        // todo: implement. Test first!
        return -1;
    }

    /**
     * Create table booking for the customer at specified date/time
     * @param customer - Customer who books the table
     * @param table - Table to be booked by the customer at the specified date/time
     * @param bookTime - Date/time at which the table is booked
     */
    public void bookTable(Customer customer, RestaurantTable table, Calendar bookTime) {
        // todo: implement. Test first!
    }

    /**
     *
     * @param bookingToBeChanged - Table booking to be changed
     * @param newCustomer -
     * @param newTable -
     * @param newBookTime -
     * @param newStatus -
     */
    // todo: Probably this method will be fully refactored
    public void changeBooking(TableBooking bookingToBeChanged, Customer newCustomer, RestaurantTable newTable,
                              Calendar newBookTime, BookingStatus newStatus) {
        // todo: implement. Test first!
    }
}
