package io.khasang.restaurant.dao.impl;

import org.hibernate.Session;

public interface BasicDao<T> {
    Session getCurrentSession();
    T create(T entity);
}
