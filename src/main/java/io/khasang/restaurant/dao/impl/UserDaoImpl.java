package io.khasang.restaurant.dao.impl;

import io.khasang.restaurant.dao.UserDao;
import io.khasang.restaurant.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao{
    @Autowired
    SessionFactory sessionFactory;
    public UserDaoImpl(Class<User> entityClass) {
            super(entityClass);
    }
    @Override
    public User create(User entity){
        return null;
    }
    @Override
    public User addUser(User user){
        sessionFactory.getCurrentSession().save(user);
        return user;
    }

    @Override
    public List<User> findByName(String name) {
        return null;
    }
}
