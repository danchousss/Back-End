package com.example.proiect.mappers.impl;

import com.example.proiect.dto.CompanyRequestDto;
import com.example.proiect.entities.Company;
import com.example.proiect.mappers.CompanyMapper;

import java.util.List;

public class CompanyMapperImpl implements CompanyMapper {
    @Override
    public Company toCompany(CompanyRequestDto companyDto) {
        if (companyDto == null) {
            return null;
        }
        Company company = new Company();
        company.setCompanyName(companyDto.getCompanyName());
        company.setCountry(companyDto.getCountry());
        return null;
    }

    @Override
    public CompanyRequestDto toCompanyDto(Company company) {
        return null;
    }

    @Override
    public List<CompanyRequestDto> toCompanyDtoList(List<Company> companies) {
        return List.of();
    }
}
