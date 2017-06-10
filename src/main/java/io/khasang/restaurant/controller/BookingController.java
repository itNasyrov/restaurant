package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.Booking;
import io.khasang.restaurant.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Booking addBooking(@RequestBody Booking booking){
        return bookingService.addBooking(booking);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Booking> getBookingList(){
        return bookingService.getBookingList();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Booking updateBooking(@RequestBody Booking booking){
        bookingService.updateBooking(booking);
        return booking;
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Booking getBookingById(@PathVariable(value = "id") String id){
        return bookingService.getBookingById(Long.parseLong(id));
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Booking deleteBooking(@PathVariable(value = "id") String id){
        return bookingService.deleteBooking(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Booking> getBookingByName(@PathVariable(value = "name") String name){
        return bookingService.getBookingByName(name);
    }

    @RequestMapping(value = "/filter/{dateBegin}/{dateEnd}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Booking> getForPeriod(@PathVariable(value="dateBegin") String dtBegin,
                                      @PathVariable(value="dateEnd") String dtEnd) {
        Timestamp tsBegin = convertStringToTimestamp(dtBegin);
        Timestamp tsEnd = convertStringToTimestamp(dtEnd);

        return bookingService.getForPeriod(tsBegin, tsEnd);
    }

    @RequestMapping(value = "/check/{dateBegin}/{dateEnd}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean isBookingAvailable(@PathVariable(value="dateBegin") String dtBegin,
                                      @PathVariable(value="dateEnd") String dtEnd) {
        Timestamp tsBegin = convertStringToTimestamp(dtBegin);
        Timestamp tsEnd = convertStringToTimestamp(dtEnd);

        return bookingService.isBookingAvailable(tsBegin, tsEnd);
    }

    private Timestamp convertStringToTimestamp(String timestampStr){
        Timestamp timestamp = null;
        if (!"null".equals(timestampStr.toLowerCase())) {
            timestamp = Timestamp.valueOf(timestampStr);
        }
        return timestamp;
    }
}
