package io.khasang.restaurant.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "id_dish")
    private long idDish;

    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    //private List<IngredientReclipe> ingredient = new ArrayList<>();

    private float proteins;

    private float fats;

    private float carbohydrates;

    @Column(name = "energy_value")
    private int energyValue;

    @Column(name = "serving_gram")
    private int servingGram;

    @Column(name = "time_сooking")
    private Time timeCooking;

    @Type(type="text")
    private String recipeText;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdDish() {
        return idDish;
    }

    public void setIdDish(long idDish) {
        this.idDish = idDish;
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

    /*public List<IngredientReclipe> getIngredient() {
        return ingredient;
    }

    public void setIngredient(List<IngredientReclipe> ingredient) {
        this.ingredient = ingredient;
    }
*/
    public Time getTimeCooking() {
        return timeCooking;
    }

    public void setTimeCooking(Time timeCooking) {
        this.timeCooking = timeCooking;
    }
}
