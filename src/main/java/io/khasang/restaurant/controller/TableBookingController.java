package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.RestaurantTable;
import io.khasang.restaurant.entity.TableBooking;
import io.khasang.restaurant.service.TableBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

/**
 * Created by firesome on 27.05.2017.
 */
@Controller
@RequestMapping("/booking")
public class TableBookingController {
    @Autowired
    private TableBookingService tableBookingService;

    // todo: RequestMapping and stuff. Probably Calendar will turn into something else
    public List<RestaurantTable> getAvailableTables(Calendar bookTime) {
        // todo: implement. Test first!
        return null;
    }

    // todo: RequestMapping and stuff. Probably Calendar will turn into something else
    public int getAvailableTablesCount(Calendar bookTime) {
        // todo: implement. Test first!
        return -1;
    }

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public TableBooking bookTable(@RequestBody TableBooking tableBooking) {
        return tableBookingService.addBooking(tableBooking);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public TableBooking updateBooking(@RequestBody TableBooking tableBooking) {
        tableBookingService.updateBooking(tableBooking);
        return tableBooking;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public TableBooking deleteBooking(@PathVariable(value = "id") String id) {
        return tableBookingService.deleteBooking(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TableBooking getDocumentById(@PathVariable(value = "id") String id){
        return tableBookingService.getBookingById(Long.parseLong(id));
    }


}
