package io.khasang.restaurant.service.impl;

import io.khasang.restaurant.dao.CompanyDao;
import io.khasang.restaurant.entity.Company;
import io.khasang.restaurant.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyDao companyDao;

    @Override
    public Company addCompany(Company company) {
        return companyDao.create(company);
    }

    @Override
    public List<Company> getCompanyList() {
        return companyDao.getList();
    }

    @Override
    public Company deleteCompany(long id) {
        return companyDao.delete(getCompanyById(id));
    }

    @Override
    public Company getCompanyById(long id){
        return companyDao.getById(id);
    }

}
