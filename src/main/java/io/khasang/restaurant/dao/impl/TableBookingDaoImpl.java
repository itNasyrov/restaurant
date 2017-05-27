package io.khasang.restaurant.dao.impl;

import io.khasang.restaurant.dao.TableBookingDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by firesome on 27.05.2017.
 */
public class TableBookingDaoImpl implements TableBookingDao {
    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

}
