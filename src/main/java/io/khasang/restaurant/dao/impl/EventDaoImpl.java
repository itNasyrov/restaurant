package io.khasang.restaurant.dao.impl;

import io.khasang.restaurant.dao.EventDao;
import io.khasang.restaurant.entity.Event;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EventDaoImpl extends BasicDaoImpl<Event> implements EventDao {
    @Autowired
    SessionFactory sessionFactory;

    public EventDaoImpl(Class<Event> entityClass) {
        super(entityClass);
    }

    @Override
    public Event create(Event entity) {
        return null;
    }

    @Override
    public Event addEvent(Event event) {
        sessionFactory.getCurrentSession().save(event);
        return event;
    }

    @Override
    public List<Event> findByName(String name) {
        return (List<Event>) sessionFactory.getCurrentSession()
                .createQuery("from Event as e where e.name = ?")
                .setParameter(0, name)
                .list();
    }
}
