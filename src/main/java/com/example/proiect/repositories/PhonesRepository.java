package com.example.proiect.repositories;

import com.example.proiect.entities.Phones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhonesRepository extends JpaRepository<Phones,Long> {
    Phones getById(Long id);

}