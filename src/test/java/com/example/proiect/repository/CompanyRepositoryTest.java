//package com.example.proiect.repository;
//
//
//import com.example.proiect.entities.Company;
//import com.example.proiect.repositories.CompanyRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//import java.util.Optional;
//
//@DataJpaTest
//public class CompanyRepositoryTest {
//
//    @Autowired
//    private CompanyRepository companyRepository;
//
//    @Test
//    public void testFindById() {
//        Company company = Company.builder()
//                .companyName("Altyn")
//                .country("Abhazia")
//                .build();
//
//        Company savedCompany = companyRepository.save(company);
//        System.out.println("Сохранённая компания: " + savedCompany);
//
//        Optional<Company> foundCompany = companyRepository.findById(savedCompany.getId());
//
//        Assertions.assertTrue(foundCompany.isPresent());
//        Assertions.assertEquals(1, foundCompany.get().getId());
//    }
//}