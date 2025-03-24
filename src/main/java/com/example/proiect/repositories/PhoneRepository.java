package com.example.proiect.repositories;

import com.example.proiect.entities.Phone;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone,Long> {
    Phone getById(Long id);


}