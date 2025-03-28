package com.example.proiect.services;

import com.example.proiect.dto.CompanyRequestDto;
import com.example.proiect.dto.CompanyResponseDto;
import com.example.proiect.entities.Company;

import java.util.List;

public interface CompanyService {
    Company getCompanyById(Long id);
    List<CompanyResponseDto> getAllCompanies();
    String createCompany(CompanyRequestDto company);
    void updateCompany(Long id, CompanyRequestDto company);
    void deleteCompany(Long id);
}
