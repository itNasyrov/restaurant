package io.khasang.restaurant.service.impl;

import io.khasang.restaurant.dao.EventDao;
import io.khasang.restaurant.entity.Event;
import io.khasang.restaurant.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("eventService")
public class EventServiceImpl implements EventService {
    @Autowired
    private EventDao eventDao;

    @Override
    public Event addEvent(Event event) {
        return eventDao.addEvent(event);
    }

    @Override
    public List<Event> getEventList() {
        return eventDao.getList();
    }

    @Override
    public Event deleteEvent(long id) {
        return eventDao.delete(getEventById(id));
    }

    @Override
    public Event getEventById(long id) {
        return eventDao.getById(id);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventDao.update(event);
    }

    @Override
    public List<Event> getEventListByName(String name) {
        return eventDao.findByName(name);
    }
}
