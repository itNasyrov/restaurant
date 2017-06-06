package io.khasang.restaurant.dao;

import io.khasang.restaurant.entity.Role;

import java.util.List;

public interface RoleDao extends BasicDao<Role>{
    /**
     * Create role at database
     *
     * @param role - role
     * @return role
     */
     Role addRole(Role role);

    /**
     * Receive role from database by name
     *
     * @param name - role name
     * @return list of roles
     */
    List<Role> findByName(String name);
}
