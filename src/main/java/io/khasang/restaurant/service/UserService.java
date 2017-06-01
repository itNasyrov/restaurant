package io.khasang.restaurant.service;

import io.khasang.restaurant.entity.User;

public interface UserService {
    /**
     * Create user at database
     *
     * @param user - user for creation
     * @return user
     */
    User addUser(User user);
}
