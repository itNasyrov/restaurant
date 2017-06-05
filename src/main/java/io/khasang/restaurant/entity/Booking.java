package io.khasang.restaurant.entity;

import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date_begin")
    @Temporal(TemporalType.DATE)
    private Date dateBegin;
    @Column(name = "date_end")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @Column(name = "id_event")
    private int idEvents;
    @Column(name = "id_menu")
    private int idMenu;
    @Column(name = "total_price")
    private double priceOfEventAndMenu;
    private String client;
    private String phone;
    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getIdEvents() {
        return idEvents;
    }

    public void setIdEvents(int idIvents) {
        this.idEvents = idIvents;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public double getPriceOfEventAndMenu() {
        return priceOfEventAndMenu;
    }

    public void setPriceOfEventAndMenu(double priceOfEventAndMenu) {
        this.priceOfEventAndMenu = priceOfEventAndMenu;
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
