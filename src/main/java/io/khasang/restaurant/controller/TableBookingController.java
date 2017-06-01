package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.TableBooking;
import io.khasang.restaurant.service.TableBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/booking")
public class TableBookingController {
    @Autowired
    private TableBookingService tableBookingService;

    @RequestMapping(value = "/all/date/{bookTime}", method = RequestMethod.GET)
    @ResponseBody
    public List<TableBooking> getAllTableBookings(@PathVariable(value = "bookTime") String bookTime)
            throws ParseException {
        return tableBookingService.getAllTableBookings(parseDateFromString(bookTime));
    }

    @RequestMapping(value = "/available/tables/date/{bookTime}", method = RequestMethod.GET)
    @ResponseBody
    public int getAvailableTablesCount(@PathVariable(value = "bookTime") String bookTime) throws ParseException {
        return tableBookingService.getAvailableTablesCount(parseDateFromString(bookTime));
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

    @RequestMapping(value = "/delete/id/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public TableBooking deleteBooking(@PathVariable(value = "id") String id) {
        return tableBookingService.deleteBooking(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public TableBooking getDocumentById(@PathVariable(value = "id") String id) {
        return tableBookingService.getBookingById(Long.parseLong(id));
    }

    private Date parseDateFromString(String strDate) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        return format.parse(strDate);
    }

}
