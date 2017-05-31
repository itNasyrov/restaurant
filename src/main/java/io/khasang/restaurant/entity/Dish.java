package io.khasang.restaurant.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int realizationTime;

    @ManyToOne(cascade = CascadeType.ALL)
    private DishCategory category;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Recipe> recipe;

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

    public int getRealizationTime() {
        return realizationTime;
    }

    public void setRealizationTime(int realizationTime) {
        this.realizationTime = realizationTime;
    }

    public DishCategory getIdCategory() {
        return category;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setCategory(DishCategory idCategory) {
        this.category = idCategory;
    }

    public DishCategory getCategory() {
        return category;
    }

    public List<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(List<Recipe> recipe) {
        this.recipe = recipe;
    }
}
