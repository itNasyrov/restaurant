package io.khasang.restaurant.service.impl;

import io.khasang.restaurant.dao.DishDao;
import io.khasang.restaurant.entity.Dish;
import io.khasang.restaurant.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dishService")
public class DishServiceImpl implements DishService {
    @Autowired
    private DishDao dishDao;

    @Override
    public Dish addDish(Dish dish) {
        return dishDao.addDish(dish);
    }

    @Override
    public List<Dish> getDocumentList() {
        return dishDao.getList();
    }

    @Override
    public Dish deleteDish(long id) {
        return dishDao.delete(getDishById(id));
    }

    @Override
    public Dish getDishById(long id) {
        return dishDao.getById(id);
    }

    @Override
    public Dish updateDish(Dish dish) {
        return dishDao.update(dish);
    }

    @Override
    public List<Dish> getDishListById(String name) {
        return dishDao.findByName(name);
    }


}
