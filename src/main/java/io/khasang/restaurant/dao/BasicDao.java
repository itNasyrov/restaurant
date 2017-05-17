package io.khasang.restaurant.dao;

import io.khasang.restaurant.entity.Document;
import org.hibernate.Session;

import java.util.List;

public interface BasicDao<T> {

    /**
     * @return current session for Hibernate
     */
    Session getCurrentSession();

    /**
     * Create entity in DB
     * @param entity - current Entity
     * @return
     */
    T create(T entity);

    /**
     * @return all entity list
     */
    List<T> getList();

    /**
     * get entity by id
     * @param id - entity id
     * @return object by id
     */
    T getById(long id);

    /**
     * delete entity
     * @param entity
     * @return entity
     */
    T delete(T entity);

    /**
     * update entity
     * @param entity
     * @return entity
     */
    T update(T entity);
}
