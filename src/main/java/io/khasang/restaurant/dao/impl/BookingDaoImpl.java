package io.khasang.restaurant.dao.impl;

import io.khasang.restaurant.dao.BookingDao;
import io.khasang.restaurant.entity.Booking;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

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
    public List<Booking> getForPeriod(Date dateBegin, Date dateEnd) {
        if (dateBegin == null) {
            dateBegin = new Date();
            dateBegin.setTime(0);
        }
        if (dateEnd == null) {
            Calendar cal = new GregorianCalendar(2100, 12, 31);
            dateEnd = new java.util.Date(cal.getTimeInMillis());
        }
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select *" +
                "from Booking b left join Event e on (e.id = b.id_event)" +
                "where b.date_begin >= :dateBegin and b.date_begin <= :dateEnd" +
                "order by b.date_begin");
        query.setParameter("dateBegin", dateBegin);
        query.setParameter("dateEnd", dateEnd);
        List<Booking> list = query.list();
        return list;
    }

    @Override
    public Boolean isBookingAvailable(Date dateBegin, Date dateEnd) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("select count(b.id)" +
                        "from Booking as b" +
                        "where (:dateBegin >= b.date_begin and :dateBegin < b.date_end) OR " +
                        "(:dateEnd <= b.date_end and :dateEnd > b.date_begin) OR " +
                        "(:dateBegin <= b.date_begin and :dateEnd >= b.date_end)");
        query.setParameter("dateBegin", dateBegin);
        query.setParameter("dateEnd", dateEnd);
        int records = query.getFirstResult();
        return (records == 0);
    }
}
