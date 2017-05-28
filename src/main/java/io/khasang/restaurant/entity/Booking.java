package io.khasang.restaurant.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date date;
    private int idIvents;
    private int idMenu;
    @Column(name = "totalPrice")
    private double priceOfIventAndMenu;
    private String available;
    private String client;
    private String phone;
    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdIvents() {
        return idIvents;
    }

    public void setIdIvents(int idIvents) {
        this.idIvents = idIvents;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public double getPriceOfIventAndMenu() {
        return priceOfIventAndMenu;
    }

    public void setPriceOfIventAndMenu(double priceOfIventAndMenu) {
        this.priceOfIventAndMenu = priceOfIventAndMenu;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String availible) {
        this.available = availible;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
