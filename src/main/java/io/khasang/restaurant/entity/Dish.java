package io.khasang.restaurant.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "dishs")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private Date Sellby;

    @Column(name = "id_category")
    private long idCategory;

    private String comment;

    public long getId() { return id; }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSellby() {
        return Sellby;
    }

    public void setSellby(Date sellby) {
        Sellby = sellby;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(long idCategory) {
        this.idCategory = idCategory;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
