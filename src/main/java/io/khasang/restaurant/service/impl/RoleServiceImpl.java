package io.khasang.restaurant.service.impl;

import io.khasang.restaurant.dao.RoleDao;
import io.khasang.restaurant.entity.Role;
import io.khasang.restaurant.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleDao roleDao;

    @Override
    public Role addRole(Role role){
        return roleDao.addRole(role);
    }

    @Override
    public Role deleteRole(long id) {
        return roleDao.delete(roleDao.getById(id));
    }

    @Override
    public List<Role> getRoleList() {
        return roleDao.getList();
    }

    @Override
    public Role updateRole(Role role) {
        return roleDao.update(role);
    }


}
