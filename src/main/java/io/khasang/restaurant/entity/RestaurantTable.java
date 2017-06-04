package io.khasang.restaurant.entity;

import javax.persistence.*;

@Entity
@Table(name = "tables")
public class RestaurantTable {
    /**
     * Table number
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Maximum count of persons that occupy the table
     */
    private int capacity;

    public RestaurantTable() {

    }

    public RestaurantTable(long id, int capacity) {
        this.id = id;
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
