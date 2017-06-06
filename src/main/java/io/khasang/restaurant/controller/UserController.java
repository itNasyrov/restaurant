package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.User;
import io.khasang.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUsertList(){
    
        return userService.getUserList();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public User updateUser(@RequestBody User user){
        userService.updateUser(user);
        return user;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public User deleteUser(@PathVariable(value = "id") String id){
        return userService.deleteUser(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable(value = "id") String id){
        return userService.getUserById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getUserListByName(@PathVariable(value = "name") String name){
        return userService.getUserListByName(name);
    }
}
