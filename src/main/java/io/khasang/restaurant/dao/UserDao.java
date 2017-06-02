package io.khasang.restaurant.dao;

import io.khasang.restaurant.entity.User;

public interface UserDao extends BasicDao<User>{
    /**
     * Create user at database
     *
     * @param user - user
     * @return user
     */
    User addUser(User user);
}
