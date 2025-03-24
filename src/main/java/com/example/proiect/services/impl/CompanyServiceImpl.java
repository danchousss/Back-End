package com.example.proiect.services.impl;

import com.example.proiect.dto.CompanyRequestDto;
import com.example.proiect.dto.CompanyResponseDto;
import com.example.proiect.entities.Company;
import com.example.proiect.mappers.CompanyMapper;
import com.example.proiect.repositories.CompanyRepository;
import com.example.proiect.services.CompanyService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyMapper companyMapper;
    private CompanyRepository companyRepository;


    @Autowired
    public CompanyServiceImpl(CompanyMapper companyMapper,CompanyRepository companyRepository
    ) {
        this.companyRepository = companyRepository;
        this.companyMapper = companyMapper;
    }


    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Company not found with id " + id));
    }

    @Override
    public List<CompanyResponseDto> getAllCompanies() {

        List<Company> companies = companyRepository.findAll();
        return companyRepository.findAll().stream()
                .map(companyMapper::toCompanyDto)
                .collect(Collectors.toList());
    }

    @Override
    public String createCompany(CompanyRequestDto company) {
        Company savedCompany =companyMapper.toCompany(company);
        if (savedCompany == null) {
            throw new IllegalArgumentException("Company entity is null after mapping!");
        }
        companyRepository.save(savedCompany);
        return "Company has been saved";
    }


    @Override
    public void updateCompany(Long id, CompanyRequestDto company) {
        Company companyToUpdate = companyRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Company not found with id " + id));
        if (company.getCompanyName() != null && !company.getCompanyName().isBlank()) {
            companyToUpdate.setCompanyName(company.getCompanyName());
        }
        companyToUpdate.setCompanyName(company.getCompanyName());
        companyToUpdate.setCountry(company.getCountry());
        companyRepository.save(companyToUpdate);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Company not found with id " + id));
        companyRepository.deleteById(id);

    }
}
