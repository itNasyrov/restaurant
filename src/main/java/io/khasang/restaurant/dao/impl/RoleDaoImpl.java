package io.khasang.restaurant.dao.impl;

import io.khasang.restaurant.dao.RoleDao;
import io.khasang.restaurant.entity.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleDaoImpl extends BasicDaoImpl<Role> implements RoleDao{
    @Autowired
    SessionFactory sessionFactory;

    public RoleDaoImpl(Class<Role> entityClass) {  super(entityClass);   }

    @Override
    public Role create(Role entity){ return null; }

    @Override
    public Role addRole(Role role){
        sessionFactory.getCurrentSession().save(role);
        return role;
    }

    @Override
    public List<Role> findByName(String name) {
        return (List<Role>) sessionFactory.getCurrentSession()
                .createQuery("from Role as r where r.name = ?")
                .setParameter(0, name)
                .list();
    }
}
