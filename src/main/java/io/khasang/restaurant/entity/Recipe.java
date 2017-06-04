package io.khasang.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "dish_id")
    private Dish dish;

    private float proteins;

    private float fats;

    private float carbohydrates;

    @Column(name = "energy_value")
    private int energyValue;

    @Column(name = "serving_gram")
    private int servingGram;

    @Column(name = "time_сooking")
    private int timeCookingMinutes;

    @Column(name = "recipe_text", columnDefinition="TEXT")
    private String recipeText;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public float getProteins() {
        return proteins;
    }

    public void setProteins(float proteins) {
        this.proteins = proteins;
    }

    public float getFats() {
        return fats;
    }

    public void setFats(float fats) {
        this.fats = fats;
    }

    public float getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(float carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getEnergyValue() {
        return energyValue;
    }

    public void setEnergyValue(int energyValue) {
        this.energyValue = energyValue;
    }

    public int getServingGram() {
        return servingGram;
    }

    public void setServingGram(int servingGram) {
        this.servingGram = servingGram;
    }

    public String getRecipeText() {
        return recipeText;
    }

    public void setRecipeText(String recipeText) {
        this.recipeText = recipeText;
    }

    public int getTimeCookingMinutes() {
        return timeCookingMinutes;
    }

    public void setTimeCookingMinutes(int timeCookingMinutes) {
        this.timeCookingMinutes = timeCookingMinutes;
    }
}
