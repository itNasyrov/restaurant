package io.khasang.restaurant.dao;

import io.khasang.restaurant.entity.Event;

import java.util.List;

public interface EventDao extends BasicDao<Event> {
    /**
     * Create Event at database
     *
     * @param event - restaurant event
     * @return event
     */
    Event addEvent(Event event);

    /**
     * Receive event from database by name
     *
     * @param name - event name
     * @return list of events
     */
    List<Event> findByName(String name);
}
