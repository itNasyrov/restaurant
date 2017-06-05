package io.khasang.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dishes")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int realizationTimeHours;

    @ManyToOne
    @JoinColumn(name = "category_id",
            foreignKey = @ForeignKey(name = "CATEGORY_ID_FK")
    )
    private DishCategory category;

    @OneToMany(mappedBy = "dish", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recipe> recipes = new ArrayList<>();

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

    public int getRealizationTimeHours() {
        return realizationTimeHours;
    }

    public void setRealizationTimeHours(int realizationTime) {
        this.realizationTimeHours = realizationTime;
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

    public void setCategory(DishCategory category) {
        this.category = category;
    }

    public DishCategory getCategory() {
        return category;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void addRecipe(Recipe recipe) {
        recipe.setDish(this);
        recipes.add(recipe);
    }

    public void removeRecipe(Recipe recipe) {
        recipes.remove(recipe);
        if (recipe != null) {
            recipe.setDish(null);
        }
    }
}
