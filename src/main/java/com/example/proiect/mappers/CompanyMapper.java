package com.example.proiect.mappers;

import com.example.proiect.dto.CompanyRequestDto;
import com.example.proiect.dto.CompanyResponseDto;
import com.example.proiect.entities.Company;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper(componentModel = "spring")
public interface CompanyMapper {

    Company toCompany(CompanyRequestDto companyDto);

    CompanyResponseDto toCompanyDto(Company company);

    List<CompanyRequestDto> toResponseList(List<Company> companies);
}
