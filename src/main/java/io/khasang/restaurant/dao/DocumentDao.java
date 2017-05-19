package io.khasang.restaurant.dao;

import io.khasang.restaurant.entity.Document;

import java.util.List;

public interface DocumentDao extends BasicDao<Document> {

    /**
     * Get document(s) from database by name
     *
     * @param name - name of document(s)
     * @return list of documents
     */
    List<Document> findByName(String name);

}
