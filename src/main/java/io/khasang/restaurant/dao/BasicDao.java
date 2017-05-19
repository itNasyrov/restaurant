package io.khasang.restaurant.dao;

import org.hibernate.Session;

import java.util.List;

public interface BasicDao<T> {
    /**
     * @return current session for Hibernate
     * */
    Session getCurrentSession();

    /**
     * Create entity in the database
     *
     * @param entity - current entity
     * @return entity
     * */
    T create(T entity);

    /**
     * @return all entity list
     * */
    List<T> getList();

    /**
     * Delete entity by id from the database
     *
     * @param entity - entity to be deleted
     * @return entity
     */
    T delete(T entity);

    /**
     * Get entity by its id from the database
     *
     * @param id - id of the entity to be got
     * @return entity
     */
    T getById(long id);

    /**
     * Update entity in the database
     *
     * @param entity - entity to be updated
     * @return updated entity
     */
    T update(T entity);
}
