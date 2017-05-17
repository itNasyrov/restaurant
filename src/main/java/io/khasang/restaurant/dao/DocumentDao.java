package io.khasang.restaurant.dao;

import io.khasang.restaurant.entity.Document;

import java.util.List;

public interface DocumentDao extends BasicDao<Document> {

    /**
     * Find and return entity with name
     * @param name
     * @return all entity list with name
     */
    List<Document> getList(String name);
}
