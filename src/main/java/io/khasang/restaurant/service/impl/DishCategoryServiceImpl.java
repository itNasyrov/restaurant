package io.khasang.restaurant.service.impl;

import io.khasang.restaurant.dao.DishCategoryDao;
import io.khasang.restaurant.entity.DishCategory;
import io.khasang.restaurant.service.DishCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dishCategoryService")
public class DishCategoryServiceImpl implements DishCategoryService {
    @Autowired
    private DishCategoryDao dishCategoryDao;

    @Override
    public DishCategory addDishCategory(DishCategory dishCategory) {
        return dishCategoryDao.addDishCategory(dishCategory);
    }

    @Override
    public List<DishCategory> getDishCategoryList() {
        return dishCategoryDao.getList();
    }

    @Override
    public DishCategory deleteDishCategory(long id) {
        return dishCategoryDao.delete(getDishCategoryById(id));
    }

    @Override
    public DishCategory getDishCategoryById(long id) {
        return dishCategoryDao.getById(id);
    }

    @Override
    public DishCategory updateDishCategory(DishCategory dishCategory) {
        return dishCategoryDao.update(dishCategory);
    }

    @Override
    public List<DishCategory> getDishCategoryList(String name) {
        return dishCategoryDao.findByName(name);
    }
}
