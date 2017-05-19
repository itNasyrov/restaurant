package io.khasang.restaurant.dao.impl;

import io.khasang.restaurant.dao.CompanyDao;
import io.khasang.restaurant.entity.Company;

public class CompanyDaoImpl extends BasicDaoImpl<Company> implements CompanyDao {

    public CompanyDaoImpl(Class<Company> entityClass) {
        super(entityClass);
    }
}
