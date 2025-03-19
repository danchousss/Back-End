package com.example.proiect.mappers;

import com.example.proiect.dto.CompanyDto;
import com.example.proiect.entities.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    Company toCompany(CompanyDto companyDto);

    CompanyDto toCompanyDto(Company company);

    List<CompanyDto> toCompanyDtoList(List<Company> companies);
}
