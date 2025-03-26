package com.example.proiect.mappers.impl;

import com.example.proiect.dto.CompanyRequestDto;
import com.example.proiect.dto.CompanyResponseDto;
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
        return company;
    }

    @Override
    public CompanyResponseDto toCompanyDto(Company company) {
        CompanyResponseDto companyDto = new CompanyResponseDto();
        companyDto.setId(company.getId());
        companyDto.setCompanyName(company.getCompanyName());
        companyDto.setCountry(company.getCountry());
        return companyDto;
    }

    @Override
    public List<CompanyRequestDto> toResponseList(List<Company> companies) {

        return List.of();
    }
}
