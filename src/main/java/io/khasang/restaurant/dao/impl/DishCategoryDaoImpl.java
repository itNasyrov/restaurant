package io.khasang.restaurant.dao.impl;

import io.khasang.restaurant.dao.DishCategoryDao;
import io.khasang.restaurant.entity.DishCategory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DishCategoryDaoImpl extends BasicDaoImpl<DishCategory> implements DishCategoryDao {
    @Autowired
    SessionFactory sessionFactory;

    public DishCategoryDaoImpl(Class<DishCategory> entityClass) {
        super(entityClass);
    }

    @Override
    public DishCategory addDishCategory(DishCategory dishCategory) {
        sessionFactory.getCurrentSession().save(dishCategory);
        return dishCategory;
    }

    @Override
    public List<DishCategory> findByName(String name) {
        return (List<DishCategory>) sessionFactory.getCurrentSession()
                .createQuery("from DishCategory as d where d.name = ?")
                .setParameter(0, name)
                .list();
    }
}
