package io.khasang.restaurant.dao.impl;

import io.khasang.restaurant.dao.DocumentDao;
import io.khasang.restaurant.entity.Document;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class DocumentDaoImpl extends BasicDaoImpl<Document> implements DocumentDao {

    @Autowired
    SessionFactory sessionFactory;

    public DocumentDaoImpl(Class<Document> entityClass) {
        super(entityClass);
    }

    @Override
    public List<Document> getList(String name) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Document> criteriaQuery = builder.createQuery(Document.class).where();
        Root<Document> root = criteriaQuery.from(Document.class);
        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("name"), name));
        return sessionFactory.getCurrentSession().createQuery(criteriaQuery).list();
    }
}
