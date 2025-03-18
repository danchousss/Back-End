package com.example.proiect.repositories;

import com.example.proiect.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomRepository extends JpaRepository<Customer,Long> {
}
