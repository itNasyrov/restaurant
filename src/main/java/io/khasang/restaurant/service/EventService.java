package io.khasang.restaurant.service;

import io.khasang.restaurant.entity.Event;

import java.util.List;

public interface EventService {
    /**
     * Create event at database
     *
     * @param event - event for creation
     * @return event
     */
    Event addEvent(Event event);

    /**
     * Receive all events
     *
     * @return all events from database
     */
    List<Event> getEventList();

    /**
     * Delete specified event by id
     *
     * @param id - id of event for deleting
     * @return
     */
    Event deleteEvent(long id);

    /**
     * Receive event by id
     *
     * @param id - event id
     * @return event
     */
    Event getEventById(long id);

    /**
     * Update event
     *
     * @param event - event from request for update
     * @return
     */
    Event updateEvent(Event event);

    /**
     * Receive event from database by name
     *
     * @param name - event name
     * @return list of events
     */
    List<Event> getEventListByName(String name);
}
