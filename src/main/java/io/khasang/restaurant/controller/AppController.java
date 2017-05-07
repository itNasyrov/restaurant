package io.khasang.restaurant.controller;

import io.khasang.restaurant.model.Cat;
import io.khasang.restaurant.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    @Autowired
    private Message message;
    @Autowired
    private Cat cat;

    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("hello", message.getName());
        return "index";
    }

    @RequestMapping("/create")
    public String createTable(Model model){
        model.addAttribute("create", cat.createCatTable());
        return "create";
    }

    @RequestMapping("/add")
    public String addTable(Model model){
        model.addAttribute("add", cat.addCatTable());
        return "add";
    }

    @RequestMapping("/delete")
    public String deleteTable(Model model){
        model.addAttribute("delete", cat.deleteCatTable());
        return "delete";
    }

    @RequestMapping("/update")
    public String updateTable(Model model){
        model.addAttribute("update", cat.updateCatTable());
        return "update";
    }
}
