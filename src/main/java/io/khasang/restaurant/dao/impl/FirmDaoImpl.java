package io.khasang.restaurant.dao.impl;

import io.khasang.restaurant.dao.FirmDao;
import io.khasang.restaurant.entity.Firm;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FirmDaoImpl extends BasicDaoImpl<Firm> implements FirmDao {
    @Autowired
    SessionFactory sessionFactory;

    public FirmDaoImpl(Class<Firm> entityClass) {
        super(entityClass);
    }

    @Override
    public Firm create(Firm entity) {
        return null;
    }

    @Override
    public Firm addFirm(Firm firm) {
        sessionFactory.getCurrentSession().save(firm);
        return firm;
    }

    @Override
    public List<Firm> findByName(String name) {
        return (List<Firm>)sessionFactory.getCurrentSession().
//                createQuery("from Firm where Firm.name=?").
                createQuery("from Firm as f where f.name=?").
                setParameter(0,name).
                list();
    }

}
