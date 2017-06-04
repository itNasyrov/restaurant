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

    /**
     * Update user
     * @param user - user from request from update
     * @return
     */
    User updateUser(User user);

    /**
     * Delete specified user by id
     *
     * @param id - id of user for deleting
     */
    User deleteUser(long id);

    /**
     * Receive user by id
     *
     * @param id - id user
     * @return user
     */
    User getUserById(long id);

    /**
     * Receive user from database by name
     *
     * @param name - user name
     * @return list of users
     */
    List<User> getUserListByName(String name);
}
