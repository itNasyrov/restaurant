package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.BookingStatus;
import io.khasang.restaurant.entity.Customer;
import io.khasang.restaurant.entity.RestaurantTable;
import io.khasang.restaurant.entity.TableBooking;
import io.khasang.restaurant.service.TableBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
     * Create table booking
     * @param tableBooking - Table booking to be created
     * @return Table booking created
     */
    @RequestMapping(value = "/bookTable", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public TableBooking bookTable(@RequestBody TableBooking tableBooking) {
        // todo: implement. Test first!
        return null;
    }

    /**
     * Update table booking
     * @param tableBooking - Table to be updated
     * @return Table booking updated
     */
    @RequestMapping(value = "/updateBooking", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public TableBooking updateBooking(@RequestBody TableBooking tableBooking) {
        // todo: implement. Test first!
        return null;
    }


    /**
     * Delete table booking
     * @param id - Id of the table booking to be deleted
     * @return Table booking deleted
     */
    @RequestMapping(value = "/deleteBooking/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public TableBooking deleteBooking(@PathVariable(value = "id") String id) {
        // todo: implement. Test first!
        return null;
    }

}
