package io.khasang.restaurant.service;

import io.khasang.restaurant.entity.User;

import java.util.List;

public interface UserService {
    /**
     * Create user at database
     * @param user - user for creation
     * @return user
     */
    User addUser(User user);

    /**
     * Get users
     * @return users list
     */
    List<User> getUserList();
}
