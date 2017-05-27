package io.khasang.restaurant.entity;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by firesome on 27.05.2017.
 */
@Entity
@Table(name = "table_bookings")
public class TableBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Registered customer who books the table
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    /**
     * Table that is booked by the customer
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id", nullable = false)
    private RestaurantTable table;

    /**
     * Date/time for which the table is booked
     */
    private Calendar bookTime;

    /**
     * Status of the booking. Default is TABLE_BOOKED
     */
    private BookingStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public RestaurantTable getTable() {
        return table;
    }

    public void setTable(RestaurantTable table) {
        this.table = table;
    }

    public Calendar getBookTime() {
        return bookTime;
    }

    public void setBookTime(Calendar bookTime) {
        this.bookTime = bookTime;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    // todo: implement preorder for registered customers
}
