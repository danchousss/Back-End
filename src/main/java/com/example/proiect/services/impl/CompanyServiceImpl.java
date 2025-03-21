package com.example.proiect.services.impl;

import com.example.proiect.entities.Company;
import com.example.proiect.mappers.CompanyMapper;
import com.example.proiect.repositories.CompanyRepository;
import com.example.proiect.services.CompanyService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;
//    private CompanyMapper companyMapper;



    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Company not found with id " + id));
    }

    @Override
    public List<Company> getAllCompanies() {
        return List.of();
    }

    @Override
    public Company createCompany(Company company) {
        return null;
    }

    @Override
    public Company updateCompany(Company company) {
        return null;
    }

    @Override
    public void deleteCompany(Long id) {

    }
}
