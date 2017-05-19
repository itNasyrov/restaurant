package io.khasang.restaurant.service;

import io.khasang.restaurant.entity.Company;

import java.util.List;

public interface CompanyService {
    /**
     * Create company in the database
     *
     * @param company - company to be created
     * @return company
     * */
    Company addCompany(Company company);

    /**
     * Get all companies
     *
     * @return all companies from database
     * */
    List<Company> getCompanyList();

    /**
     * Delete company by id;
     *
     * @param id - id of the company to be deleted
     * @return company deleted
     */
    Company deleteCompany(long id);

    /**
     * Get company by id
     *
     * @param id - id of the company
     * @return company
     */
    Company getCompanyById(long id);

    /**
     * Update company
     *
     * @param company - companyto be updated
     * @return updated company
     */
    Company updateCompany(Company company);

}
