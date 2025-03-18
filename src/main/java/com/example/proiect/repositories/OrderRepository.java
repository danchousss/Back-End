package com.example.proiect.repositories;

import com.example.proiect.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {

}
