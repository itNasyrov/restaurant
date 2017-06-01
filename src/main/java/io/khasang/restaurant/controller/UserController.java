package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.User;
import io.khasang.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value ="/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8");
    @ResponseBody
    public User addUser(@RequestBody User user){
        return userService.addUser(user);}
}
