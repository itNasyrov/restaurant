package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.Dish;
import io.khasang.restaurant.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Dish addDocument(@RequestBody Dish dish){
        return dishService.addDish(dish);
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Dish> getDocumentList(){
        return dishService.getDocumentList();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Dish deleteDish(@PathVariable(value = "id") String id) {
        return dishService.deleteDish(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Dish getDishById(@PathVariable(value = "id") String id) {
        return dishService.getDishById(Long.parseLong(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Dish updateDish(@RequestBody Dish dish) {
        dishService.updateDish(dish);
        return dish;
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<Dish> getDishListById(@PathVariable(value = "name") String name) {
        return dishService.getDishListById(name);
    }
}
