package io.khasang.restaurant.entity;

import javax.persistence.*;

/**
 * Created by firesome on 27.05.2017.
 */
@Entity
@Table(name = "customers")
public class Customer {
    // todo: Customer (one) <-> TableBooking.customer (many)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
