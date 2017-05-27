package io.khasang.restaurant.dao.impl;

import io.khasang.restaurant.dao.TableBookingDao;
import io.khasang.restaurant.entity.TableBooking;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by firesome on 27.05.2017.
 */
public class TableBookingDaoImpl extends BasicDaoImpl<TableBooking> implements TableBookingDao {

    @Autowired
    protected SessionFactory sessionFactory; // todo: check if this is necessary

    public TableBookingDaoImpl(Class<TableBooking> entityClass) {
        super(entityClass);
    }
}
