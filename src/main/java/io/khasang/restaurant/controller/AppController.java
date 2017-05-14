package io.khasang.restaurant.controller;

import io.khasang.restaurant.model.Cat;
import io.khasang.restaurant.entity.Document;
import io.khasang.restaurant.model.Message;
import io.khasang.restaurant.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class AppController {
    @Autowired
    private Message message;
    @Autowired
    private Cat cat;

    private Note note;

    @RequestMapping("/")
    public String hello(Model model) {
        model.addAttribute("hello", message.getName());

        Random rn = new Random();
        note = new Note("Ля-ля-ля..." + rn.nextInt());
        model.addAttribute("note", note.getText());

        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createTable(Model model){
        model.addAttribute("create", cat.createCatTable());
        return "create";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insertToTable(Model model){
        cat.setId(11);
        cat.setName("Valmont");
        model.addAttribute("insert", cat.insertCatToTable(cat));
        return "insert";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateTable(Model model){
        model.addAttribute("update", cat.updateCatTable(11));
        return "update";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteFromTable(Model model){
        model.addAttribute("delete", cat.deleteFromTable(11));
        return "delete";
    }

    @RequestMapping("/list")
    public String getList(Model model){
        List<Document> documentList = new ArrayList<>();
        documentList.add(new Document(3, "Cat"));
        documentList.add(new Document(2, "Dog"));
        model.addAttribute("list", documentList);
        return "list";
    }

    @RequestMapping("/user/page")
    public String getUser(){
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
