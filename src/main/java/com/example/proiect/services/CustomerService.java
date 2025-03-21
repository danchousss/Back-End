package com.example.proiect.services;

import com.example.proiect.entities.Customer;

import java.util.List;

public interface CustomerService{
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Long id);
}
