package io.khasang.restaurant.controller;

import io.khasang.restaurant.model.Message;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppController {
    @RequestMapping("/")
    public String hello() {
        return "index";
    }

    @RequestMapping("/user")
    public String getUser(){ return "user"; }

    @RequestMapping("/role")
    public String getRole() { return "role"; }

    @RequestMapping("/list")
    public String getList(Model model){
        List<Message> messagesList = new ArrayList<>();
        messagesList.add(new Message(3, "Catty"));
        messagesList.add(new Message(2, "Dog"));
        model.addAttribute("list", messagesList);
        return "list";
    }

    @RequestMapping("/user/page")
    public String getUsers(){
        return "page";
    }

    @RequestMapping("/admin/page")
    public String getAdmin(){
        return "admin";
    }

    @RequestMapping(value = {"/password/{password}"}, method = RequestMethod.GET)
    public ModelAndView passwordEncode(@PathVariable("password") String password){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("password");
        modelAndView.addObject("crypt", new BCryptPasswordEncoder().encode(password));
        return modelAndView;
    }

}
