package io.khasang.restaurant.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

@Transactional
public abstract class BasicDaoImpl<T> implements BasicDao<T> {
    private final Class<T> entityClass;

    protected BasicDaoImpl(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    protected SessionFactory sessionFactory;

    @Override
    public T create(T entity) {
        getCurrentSession().save(entity);
        return entity;
    }
}