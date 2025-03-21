package com.example.proiect.services;

import com.example.proiect.entities.Company;

import java.util.List;

public interface CompanyService {
    Company getCompanyById(Long id);
    List<Company> getAllCompanies();
    Company createCompany(Company company);
    Company updateCompany(Company company);
    void deleteCompany(Long id);


}
