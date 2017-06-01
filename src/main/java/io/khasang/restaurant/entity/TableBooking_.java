package io.khasang.restaurant.entity;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;
import java.util.List;

@StaticMetamodel( TableBooking.class )
public class TableBooking_ {
    public static volatile SingularAttribute<TableBooking, Long> id;
    public static volatile SingularAttribute<TableBooking, Customer> customer;
    public static volatile ListAttribute<TableBooking, List<RestaurantTable>> tables;
    public static volatile SingularAttribute<TableBooking, Date> bookTime;
    public static volatile SingularAttribute<TableBooking, BookingStatus> status;
}