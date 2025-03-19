package com.example.proiect.bootstrap;

import com.example.proiect.entities.Company;
import com.example.proiect.entities.Customer;
import com.example.proiect.entities.Phones;
import com.example.proiect.repositories.CompanyRepository;
import com.example.proiect.repositories.CustomRepository;
import com.example.proiect.repositories.OrderRepository;
import com.example.proiect.repositories.PhonesRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class InitData {

    private final CustomRepository customRepository;
    private String myProperty;

    private final PhonesRepository phonesRepository;
    private final CompanyRepository companyRepository;
    private final OrderRepository orderRepository;

    @PostConstruct
    public void init() {

        log.warn("Init data");
        Company company = Company.builder()
                .companyName("Daniel")
                .country("Nigeria")
                .build();
        companyRepository.save(company);

        Phones iphone = Phones.builder()
                .model("iphone")
                .company(company)
                .price(123L)
                .yearOfRelease(1928L)
                .build();
        phonesRepository.save(iphone);

        Phones samsung = Phones.builder()
                .model("samsung")
                .company(company)
                .price(456L)
                .yearOfRelease(1929L)
                .build();
        phonesRepository.save(samsung);

        Customer custom=Customer.builder()
                .name("Gustavo")
                .phone("+996500777777")
                .build();
        customRepository.save(custom);


    }
}
