package io.khasang.restaurant.dao.impl;

import io.khasang.restaurant.dao.BookingDao;
import io.khasang.restaurant.entity.Booking;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class BookingDaoImpl extends BasicDaoImpl<Booking> implements BookingDao{
    @Autowired
    private SessionFactory sessionFactory;

    public BookingDaoImpl(Class<Booking> entityClass){
        super(entityClass);
    }

    @Override
    public Booking create(Booking entity) {
        return null;
    }

    @Override
    public Booking addBooking(Booking booking) {
        sessionFactory.getCurrentSession().save(booking);
        return booking;
    }

    @Override
    public List<Booking> getByName(String name) {
        return (List<Booking>)sessionFactory.getCurrentSession()
                .createQuery("from Booking where client = ?")
                .setParameter(0,name)
                .list();
    }

    @Override
    public List<Booking> getForPeriod(Timestamp dateBegin, Timestamp dateEnd) {
        /*
        if (dateBegin == null) {
            dateBegin = (Timestamp) new Date();
            dateBegin.setTime(0);
        }
        if (dateEnd == null) {
            Calendar cal = new GregorianCalendar(2100, 12, 31);
            dateEnd = new Timestamp(cal.getTimeInMillis());
        }
        */
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select b.id, b.dateBegin, b.dateEnd, e.name, b.client, b.quantity, b.priceOfEventAndMenu, b.phone " +
                "from Booking b left join Event e on (e.id = b.idEvent) " +
                "where b.dateBegin between :dateBegin and :dateEnd " +
                "order by b.dateBegin");
        query.setParameter("dateBegin", dateBegin);
        query.setParameter("dateEnd", dateEnd);
        List<Booking> list = query.list();
        return list;
    }

    @Override
    public Boolean isBookingAvailable(Timestamp dateBegin, Timestamp dateEnd) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select count(b.id) " +
                        "from Booking as b " +
                        "where (:dateBegin >= b.dateBegin and :dateBegin < b.dateEnd) OR " +
                        "(:dateEnd <= b.dateEnd and :dateEnd > b.dateBegin) OR " +
                        "(:dateBegin <= b.dateBegin and :dateEnd >= b.dateEnd)");
        query.setParameter("dateBegin", dateBegin);
        query.setParameter("dateEnd", dateEnd);
        int records = query.getFirstResult();
        return (records == 0);
    }
}
