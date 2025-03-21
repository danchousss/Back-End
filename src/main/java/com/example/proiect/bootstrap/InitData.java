package com.example.proiect.bootstrap;

import com.example.proiect.entities.Company;
import com.example.proiect.entities.Customer;
import com.example.proiect.entities.Order;
import com.example.proiect.entities.Phone;
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
        Company company3 = Company.builder()
                .companyName("Daniel")
                .country("Nigeria")
                .build();
        companyRepository.save(company3);
        Company company = Company.builder()
                .companyName("Daniel")
                .country("Nigeria")
                .build();
        companyRepository.save(company);

        System.out.println(company.getId());

        Phone iphone = Phone.builder()
                .model("iphone")
                .company(company)
                .price(123L)
                .yearOfRelease(1928L)
                .build();
        phonesRepository.save(iphone);

        Phone samsung = Phone.builder()
                .model("samsung")
                .company(company)
                .price(456L)
                .yearOfRelease(1929L)
                .build();
        phonesRepository.save(samsung);

        Phone nokia = Phone.builder()
                .model("nokkia")
                .company(company3)
                .price(46L)
                .yearOfRelease(192L)
                .build();
        phonesRepository.save(nokia);

        Customer custom=Customer.builder()
                .name("Gustavo")
                .phone("+996500777777")
                .build();
        customRepository.save(custom);

        Order order = Order.builder()
                .price(123L)
                .phones(nokia)
                .customer(custom)
                .build();
    }

}
