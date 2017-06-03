package io.khasang.restaurant.dao;

import io.khasang.restaurant.entity.User;

import java.util.List;
public interface UserDao extends BasicDao<User>{
    /**
     * Create user at database
     *
     * @param user - user
     * @return user
     */
    User addUser(User user);

    /**
     * Get list of users
     * @param name - user name
     * @return list of users
     */
    List<User> findByName(String name);

}
