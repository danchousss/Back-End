package com.example.proiect.services.impl;

import com.example.proiect.dto.PhoneRequestDto;
import com.example.proiect.dto.PhoneResponseDto;
import com.example.proiect.entities.Company;
import com.example.proiect.entities.Phone;
import com.example.proiect.mappers.CompanyMapper;
import com.example.proiect.mappers.PhoneMapper;
import com.example.proiect.repositories.CompanyRepository;
import com.example.proiect.repositories.PhoneRepository;
import com.example.proiect.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneServiceImpl implements PhoneService {
    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Autowired
    public PhoneServiceImpl(PhoneRepository phoneRepository, PhoneMapper phoneMapper, CompanyRepository companyRepository,CompanyMapper companyMapper) {
        this.phoneRepository = phoneRepository;
        this.phoneMapper = phoneMapper;
        this.companyRepository = companyRepository;
        this.companyMapper=companyMapper;
    }

    @Override
    public Phone getPhoneById(Long id) {
        return phoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phone not found with id "+ id));

    }

    @Override
    public List<PhoneResponseDto> getAllPhones() {
        List<Phone> phones = phoneRepository.findAll();
        return phoneRepository.findAll().stream()
                .map(phoneMapper::toPhoneDto)
                .collect(Collectors.toList());
    }

    @Override
    public String createPhone(PhoneRequestDto phone) {
        Phone savedPhone = phoneMapper.toPhone(phone);
        if(savedPhone==null){
            throw new IllegalArgumentException("Phone entity is null after mapping!");
        }
        phoneRepository.save(savedPhone);
        return "Phone has been created";
    }

    @Override
    public void updatePhone(Long id, PhoneRequestDto phoneDto) {
        Phone phoneToUpdate = phoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phone not found with id " + id));

        Company company = companyRepository.findById(phoneDto.getCompanyId())
                .orElseThrow(() -> new RuntimeException("Company not found with id " + phoneDto.getCompanyId()));

        phoneToUpdate.setCompany(company);
        phoneToUpdate.setModel(phoneDto.getModel());
        phoneToUpdate.setPrice(phoneDto.getPrice());
        phoneToUpdate.setYearOfRelease(phoneDto.getYearOfRelease());

        phoneRepository.save(phoneToUpdate);
    }


    @Override
    public void deletePhone(Long id) {
        phoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Phone not found with id " + id));
        phoneRepository.deleteById(id);

    }
}
