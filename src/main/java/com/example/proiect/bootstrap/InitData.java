package com.example.proiect.bootstrap;

import com.example.proiect.entities.Company;
import com.example.proiect.entities.Customer;
import com.example.proiect.entities.Order;
import com.example.proiect.entities.Phone;
import com.example.proiect.repositories.CompanyRepository;
import com.example.proiect.repositories.CustomerRepository;
import com.example.proiect.repositories.OrderRepository;
import com.example.proiect.repositories.PhoneRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class InitData {

    private final CustomerRepository customRepository;
    private String myProperty;

    private final PhoneRepository phonesRepository;
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
                .companyName("Sony")
                .country("Japan")
                .build();
        companyRepository.save(company);
        Company company1 = Company.builder()
                .companyName("Honor")
                .country("Usa")
                .build();
        companyRepository.save(company1);


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
                .address("Mexico")
                .build();
        customRepository.save(custom);

        Customer custom1=Customer.builder()
                .name("Alex")
                .phone("+99650077777")
                .address("USA")
                .build();
        customRepository.save(custom1);

        Customer custom2=Customer.builder()
                .name("Zabit")
                .phone("+99650077777")
                .address("Dagestan")
                .build();
        customRepository.save(custom2);

        Customer custom3=Customer.builder()
                .name("Sergei")
                .phone("+99650077777")
                .address("Dagestan")
                .build();
        customRepository.save(custom3);

        Order order = Order.builder()
                .price(123L)
                .phones(nokia)
                .customer(custom)
                .build();
    }

}
