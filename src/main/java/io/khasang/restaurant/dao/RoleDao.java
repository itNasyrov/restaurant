package io.khasang.restaurant.dao;

import io.khasang.restaurant.entity.Role;

public interface RoleDao extends BasicDao<Role>{
    /**
     * Create role at database
     *
     * @param role - role
     * @return role
     */
     Role addRole(Role role);
}
