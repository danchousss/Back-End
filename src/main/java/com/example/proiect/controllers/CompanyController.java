package com.example.proiect.controllers;


import com.example.proiect.dto.CompanyRequestDto;
import com.example.proiect.dto.CompanyResponseDto;
import com.example.proiect.entities.Company;
import com.example.proiect.services.CompanyService;
import com.example.proiect.services.impl.CompanyServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/company")
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable ("id") Long id) {
        return  ResponseEntity.ok().body(companyService.getCompanyById(id));
    }
    @GetMapping()
    public ResponseEntity<List<CompanyResponseDto>> getAllCompanies() {
        List<CompanyResponseDto>companies = companyService.getAllCompanies();
        return  ResponseEntity.ok(companies);
    }
    @PostMapping
    public String createCompany(@RequestBody CompanyRequestDto companyRequestDto) {
        return companyService.createCompany(companyRequestDto);
    }
    @PutMapping("/{id}")
    public String updateCompany(@PathVariable ("id") Long id,@Valid @RequestBody CompanyRequestDto companyRequestDto) {
        companyService.updateCompany(id, companyRequestDto);
        return "Company updated successfully";
    }
    @DeleteMapping("/{id}")
    public String deleteCompanyBy(@PathVariable ("id") Long id){
         companyService.deleteCompany(id);
        return "Company successfully deleted";
    }
}
