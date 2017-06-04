package io.khasang.restaurant.service;

import io.khasang.restaurant.entity.Role;

import java.util.List;

public interface RoleService{
    /**
     * Create role at database
     *
     * @param role - role for creation
     * @return role
     */
    Role addRole(Role role);

    /**
     * Update role at database
     * @param role - role for update
     * @return role
     */
    Role updateRole(Role role);

    /**
     * Delete role by id
     * @param id - role id for request
     */
    Role deleteRole(long id);

    /**
     * Get list of roles
     * @return all roles from database
     */
    List<Role> getRoleList();
}
