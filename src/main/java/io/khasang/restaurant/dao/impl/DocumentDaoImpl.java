package io.khasang.restaurant.dao.impl;

import io.khasang.restaurant.dao.DocumentDao;
import io.khasang.restaurant.entity.Document;

import java.util.List;

public class DocumentDaoImpl extends BasicDaoImpl<Document> implements DocumentDao {

    public DocumentDaoImpl(Class<Document> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Document> findByName(String name) {
        return (List<Document>) sessionFactory.getCurrentSession()
                .createQuery("from Document as d where d.name = ?")
                .setParameter(0, name)
                .list();
    }
}
