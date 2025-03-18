package com.example.proiect.repositories;

import com.example.proiect.entities.Company;
import com.example.proiect.entities.Phones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    Company getById(Long id);
}
