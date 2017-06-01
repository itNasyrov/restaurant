package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.Role;
import io.khasang.restaurant.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    //@RequestMapping(value ="/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8");
    @RequestMapping(value ="/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8");
    @ResponseBody
    public Role addRole(@RequestBody Role role){
        return roleService.addRole(role);

    }


}
