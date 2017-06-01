package io.khasang.restaurant.service;

import io.khasang.restaurant.entity.Role;

public interface RoleService {
    /**
     * Create role at database
     *
     * @param role - role for creation
     * @return role
     */
    Role addRole(Role role);
}
