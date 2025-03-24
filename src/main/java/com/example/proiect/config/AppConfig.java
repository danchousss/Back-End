package com.example.proiect.config;

import com.example.proiect.mappers.CompanyMapper;
import com.example.proiect.mappers.CustomerMapper;
import com.example.proiect.mappers.OrderMapper;
import com.example.proiect.mappers.PhoneMapper;
import com.example.proiect.mappers.impl.CompanyMapperImpl;
import com.example.proiect.mappers.impl.CustomerMapperImpl;
import com.example.proiect.mappers.impl.OrderMapperImpl;
import com.example.proiect.mappers.impl.PhoneMapperImpl;
import com.example.proiect.repositories.CustomerRepository;
import com.example.proiect.repositories.OrderRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CompanyMapper companyMapper() {
        return new CompanyMapperImpl();
    }

    @Bean
    public OrderMapper orderMapper() {
        return new OrderMapperImpl();
    }

    @Bean
    public PhoneMapper phoneMapper() {
        return new PhoneMapperImpl();
    }

    @Bean
    public CustomerMapper customerMapper() {
        return new CustomerMapperImpl();
    }
}
