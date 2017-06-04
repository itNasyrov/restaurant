package io.khasang.restaurant.dao.impl;

import io.khasang.restaurant.dao.TableBookingDao;
import io.khasang.restaurant.model.BookingStatus;
import io.khasang.restaurant.entity.RestaurantTable;
import io.khasang.restaurant.entity.TableBooking;
import io.khasang.restaurant.entity.TableBooking_;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TableBookingDaoImpl extends BasicDaoImpl<TableBooking> implements TableBookingDao {

    @Autowired
    protected SessionFactory sessionFactory;

    public TableBookingDaoImpl(Class<TableBooking> entityClass) {
        super(entityClass);
    }

    @Override
    public List<TableBooking> getAllTableBookings(Date bookTime) throws ParseException {
        Date dateWithoutTime = removeTimeFromDatetime(bookTime);

        return (List<TableBooking>)sessionFactory.getCurrentSession()
                .createQuery("from TableBooking tb " +
                        "where tb.bookTime between :start and :end")
                .setParameter("start", dateWithoutTime)
                .setParameter("end", new Date(dateWithoutTime.getTime() + 1000 * (59 + 59*60 + 23*60*60)))
                .list();
    }

    @Override
    public int getAvailableTablesCount(Date bookTime) throws ParseException {

        Class entityClass = RestaurantTable.class;
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<RestaurantTable> criteriaQuery = builder.createQuery(entityClass);
        Root<RestaurantTable> root = criteriaQuery.from(entityClass);
        criteriaQuery.select(root);
        List<RestaurantTable> tablesList = sessionFactory.getCurrentSession().createQuery(criteriaQuery).list();
        int allTablesCount = (tablesList != null ? tablesList.size() : 0);

        Date dateWithoutTime = removeTimeFromDatetime(bookTime);

        entityClass = TableBooking.class;
        builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<TableBooking> criteriaQuery2 = builder.createQuery(entityClass);
        Root<TableBooking> root2 = criteriaQuery2.from(entityClass);
        criteriaQuery2.select(root2);
        criteriaQuery2.where(builder.and(
                builder.between(root2.get(TableBooking_.bookTime), dateWithoutTime,
                        new Date(dateWithoutTime.getTime() + 1000 * (59 + 59*60 + 23*60*60))),
                builder.or(
                        builder.equal(root2.get(TableBooking_.status), BookingStatus.TABLE_BOOKED),
                        builder.equal(root2.get(TableBooking_.status), BookingStatus.TABLE_OPENED)
                    )
                )
        );
        List<TableBooking> tbList = sessionFactory.getCurrentSession().createQuery(criteriaQuery2).list();

        int occupiedTablesCount = tbList != null ? new HashSet<TableBooking>(tbList).size() : 0;

        return allTablesCount - occupiedTablesCount;
    }

    private Date removeTimeFromDatetime(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(sdf.format(date));
    }

}
