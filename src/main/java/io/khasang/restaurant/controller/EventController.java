package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.Event;
import io.khasang.restaurant.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Event addEvent(@RequestBody Event event) {
        return eventService.addEvent(event);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Event> getEventList() {
        return eventService.getEventList();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Event deleteEvent(@PathVariable(value = "id") String id){
        return eventService.deleteEvent(Long.parseLong(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Event updateEvent(@RequestBody Event event) {
        eventService.updateEvent(event);
        return event;
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Event getEventById(@PathVariable(value = "id") String id) {
        return eventService.getEventById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Event> getEventListByName(@PathVariable(value = "name") String name) {
        return eventService.getEventListByName(name);
    }
}
