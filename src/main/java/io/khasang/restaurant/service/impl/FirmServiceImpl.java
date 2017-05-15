package io.khasang.restaurant.service.impl;

import io.khasang.restaurant.dao.FirmDao;
import io.khasang.restaurant.entity.Firm;
import io.khasang.restaurant.service.FirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("firmService")
public class FirmServiceImpl implements FirmService {
    @Autowired
    private FirmDao firmDao;

    @Override
    public Firm addFirm(Firm firm) {
        return firmDao.addFirm(firm);
    }

    @Override
    public List<Firm> getFirmList() {
        return firmDao.getList();
    }

    @Override
    public Firm deleteFirm(long id) {
        return firmDao.delete(getFirmById(id));
    }

    public Firm getFirmById(long id){
        return firmDao.getById(id);
    }

    @Override
    public Firm updateFirm(Firm firm) {
        return firmDao.update(firm);
    }

    @Override
    public List<Firm> getFirmListByName(String name) {
        return firmDao.findByName(name);
    }
}
