package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.Role;
import io.khasang.restaurant.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Role addRole(@RequestBody Role role){
        return roleService.addRole(role);
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Role updateRole(@RequestBody Role role){
        return roleService.updateRole(role);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Role deleteRole(@PathVariable(value = "id") String id){
        return roleService.deleteRole(Long.parseLong(id));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Role> getDocumentList(){
        return roleService.getRoleList();
    }


}
