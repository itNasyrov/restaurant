package io.khasang.restaurant.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date_begin")
    private Timestamp dateBegin;
    @Column(name = "date_end")
    private Timestamp dateEnd;
    @Column(name = "id_event")
    private int idEvent;
    @Column(name = "id_menu")
    private int idMenu;
    @Column(name = "total_price")
    private BigDecimal priceOfEventAndMenu;
    private String client;
    private String phone;
    private int quantity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Timestamp getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Timestamp dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Timestamp getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Timestamp dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idIvent) {
        this.idEvent = idIvent;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public BigDecimal getPriceOfEventAndMenu() {
        return priceOfEventAndMenu;
    }

    public void setPriceOfEventAndMenu(BigDecimal priceOfEventAndMenu) {
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
