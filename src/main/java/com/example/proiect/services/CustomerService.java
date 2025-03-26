package com.example.proiect.services;

import com.example.proiect.dto.CustomerRequestDto;
import com.example.proiect.dto.CustomerResponseDto;
import com.example.proiect.entities.Customer;

import java.util.List;

public interface CustomerService{
    Customer getCustomerById(Long id);
    List<CustomerResponseDto> getAllCustomers();
    String createCustomer(CustomerRequestDto customer);
    void updateCustomer(Long id, CustomerRequestDto customer);
    void deleteCustomer(Long id);

}
