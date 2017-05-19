package io.khasang.restaurant.controller;

import io.khasang.restaurant.entity.Company;
import io.khasang.restaurant.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Company addCompany(@RequestBody Company company) {
        return companyService.addCompany(company);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Company> getCompanyList() {
        return companyService.getCompanyList();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Company deleteCompany(@PathVariable(value = "id") String id) {
        return companyService.deleteCompany(Long.parseLong(id));
    }

}
