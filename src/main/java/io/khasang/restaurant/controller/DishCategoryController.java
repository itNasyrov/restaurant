package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.DishCategory;
import io.khasang.restaurant.service.DishCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dishcategory")
public class DishCategoryController {
    @Autowired
    private DishCategoryService dishCategoryService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public DishCategory addDocument(@RequestBody DishCategory dishCategory){
        return dishCategoryService.addDishCategory(dishCategory);
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<DishCategory> getDocumentList(){
        return dishCategoryService.getDishCategoryList();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public DishCategory deleteDishCategory(@PathVariable(value = "id") String id) {
        return dishCategoryService.deleteDishCategory(Long.parseLong(id));
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    @ResponseBody
    public DishCategory getDishCategoryById(@PathVariable(value = "id") String id) {
        return dishCategoryService.getDishCategoryById(Long.parseLong(id));
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public DishCategory updateDish(@RequestBody DishCategory dishCategory) {
        dishCategoryService.updateDishCategory(dishCategory);
        return dishCategory;
    }

    @RequestMapping(value = "/get/name/{name}", method = RequestMethod.GET)
    @ResponseBody
    public List<DishCategory> getDishCategoryListById(@PathVariable(value = "name") String name) {
        return dishCategoryService.getDishCategoryList(name);
    }
}
