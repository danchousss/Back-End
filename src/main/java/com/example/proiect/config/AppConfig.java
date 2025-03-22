package com.example.proiect.config;

import com.example.proiect.mappers.CompanyMapper;
import com.example.proiect.mappers.impl.CompanyMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CompanyMapper companyMapper() {
        return new CompanyMapperImpl(); // или другой способ создания маппера
    }
}
