package io.khasang.restaurant.dao.impl;

import io.khasang.restaurant.dao.RecipeDao;
import io.khasang.restaurant.entity.Recipe;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RecipeDaoImpl extends BasicDaoImpl<Recipe> implements RecipeDao {
    @Autowired
    SessionFactory sessionFactory;

    public RecipeDaoImpl(Class<Recipe> entityClass) {
        super(entityClass);
    }

    @Override
    public Recipe addRecipe(Recipe recipe) {
        sessionFactory.getCurrentSession().save(recipe);
        return recipe;
    }

    @Override
    public List<Recipe> findByText(String text) {
        String pattern = "%?%";
        return (List<Recipe>) sessionFactory.getCurrentSession()
                .createQuery("from Recipe as r where r.recipeText like " + pattern)
                .setParameter(0, text)
                .list();
    }
}
