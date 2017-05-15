package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.Firm;
import io.khasang.restaurant.service.FirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/firm")
public class FirmController {
    @Autowired
    private FirmService firmService;

    @RequestMapping(value = "/add",method = RequestMethod.PUT,produces = "application/json;charset=utf-8")
    @ResponseBody
    public Firm addFirm(@RequestBody Firm firm){
        return firmService.addFirm(firm);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Firm> getFirmList(){
        return firmService.getFirmList();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Firm deleteFirm(@PathVariable(value = "id") String id){
        return firmService.deleteFirm(Long.parseLong(id));
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Firm updateFirm(@RequestBody Firm firm){
        return firmService.updateFirm(firm);
    }

    @RequestMapping(value = "/get/id/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Firm getFirmById(@PathVariable(value = "id") String id){
        return firmService.getFirmById(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Firm> getFirmListByName(@PathVariable(value = "name") String name){
        return firmService.getFirmListByName(name);

    }
}
