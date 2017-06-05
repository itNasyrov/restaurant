package io.khasang.restaurant.dao.impl;

import io.khasang.restaurant.dao.DishDao;
import io.khasang.restaurant.entity.Dish;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DishDaoImpl extends BasicDaoImpl<Dish> implements DishDao {
    @Autowired
    SessionFactory sessionFactory;

    public DishDaoImpl(Class<Dish> entityClass) {
        super(entityClass);
    }

    @Override
    public Dish addDish(Dish dish) {
        sessionFactory.getCurrentSession().persist(dish);
        return dish;
    }

    @Override
    public List<Dish> findByName(String name) {
        return (List<Dish>) sessionFactory.getCurrentSession()
                .createQuery("from Dish as d where d.name = ?")
                .setParameter(0, name)
                .list();
    }
}
