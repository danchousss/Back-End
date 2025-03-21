package com.example.proiect.mappers;

import com.example.proiect.dto.CompanyRequestDto;
import com.example.proiect.entities.Company;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company toCompany(CompanyRequestDto companyDto);

    CompanyRequestDto toCompanyDto(Company company);

    List<CompanyRequestDto> toCompanyDtoList(List<Company> companies);
}
