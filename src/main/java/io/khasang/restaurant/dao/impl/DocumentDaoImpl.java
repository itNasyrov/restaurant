package io.khasang.restaurant.dao.impl;

import io.khasang.restaurant.dao.DocumentDao;
import io.khasang.restaurant.entity.Document;

public class DocumentDaoImpl extends BasicDaoImpl<Document> implements DocumentDao {

    public DocumentDaoImpl(Class<Document> entityClass) {
        super(entityClass);
    }

}
