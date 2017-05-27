package io.khasang.restaurant.dao;

import org.hibernate.Session;

import java.util.List;

public interface BasicDao<T> {

    /**
     * @return Current hibernate session
     */
    Session getCurrentSession();

    /**
     * Create entity in the database
     * @param entity - Entity to be created
     * @return Created entity
     */
    T create(T entity);

    /**
     * @return List of all entities
     */
    List<T> getList();

    /**
     * Get entity by id from the database
     * @param id - Id of the entity
     * @return Entity taken from the database
     */
    T getById(long id);

    /**
     * Delete entity by id from database
     * @param entity - Entity to be deleted
     * @return Deleted entity
     */
    T delete(T entity);

    /**
     * Update entity in the database
     * @param entity - Entity to be updated
     * @return Updated entity
     */
    T update(T entity);
}
