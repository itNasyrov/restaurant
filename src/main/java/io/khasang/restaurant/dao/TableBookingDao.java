package io.khasang.restaurant.dao;

import org.hibernate.Session;

/**
 * Created by firesome on 27.05.2017.
 */
public interface TableBookingDao {

    /**
     * @return current session for Hibernate
     */
    Session getCurrentSession();


}
