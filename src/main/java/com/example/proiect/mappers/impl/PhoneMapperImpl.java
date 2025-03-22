package com.example.proiect.mappers.impl;

import com.example.proiect.dto.PhoneRequestDto;
import com.example.proiect.dto.PhoneResponseDto;
import com.example.proiect.entities.Company;
import com.example.proiect.entities.Phone;
import com.example.proiect.mappers.PhoneMapper;
import com.example.proiect.repositories.CompanyRepository;

import java.util.List;

public class PhoneMapperImpl implements PhoneMapper {
    private final CompanyRepository companyRepository;

    public PhoneMapperImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
    @Override
    public Phone toPhone(PhoneRequestDto phoneDto) {
        if (phoneDto == null) {
            return null;
        }
        Phone phone = new Phone();
        phone.setModel(phoneDto.getModel());
        phone.setPrice(phoneDto.getPrice());
        phone.setYearOfRelease(phoneDto.getYearOfRelease());
        Company company = companyRepository.findById(phoneDto.getCompany_id())
                .orElseThrow(() -> new RuntimeException("Company not found"));
        phone.setCompany(company);
        return phone;
    }

    @Override
    public PhoneResponseDto toPhoneDto(Phone phone) {
        if (phone == null) {
            return null;
        }
        PhoneResponseDto phoneDto = new PhoneResponseDto();
        phoneDto.setModel(phone.getModel());
        phoneDto.setPrice(phone.getPrice());
        phoneDto.setYearOfRelease(phone.getYearOfRelease());
        Company company = companyRepository.findById(phoneDto.getCompany_id())
                .orElseThrow(() -> new RuntimeException("Company not found"));
        phone.setCompany(company);
        return phoneDto;
    }

    @Override
    public List<PhoneRequestDto> toResponseList(List<Phone> phones)    {
        return List.of();
    }

}
