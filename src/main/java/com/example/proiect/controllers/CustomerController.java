package com.example.proiect.controllers;

import com.example.proiect.dto.CompanyResponseDto;
import com.example.proiect.dto.CustomerRequestDto;
import com.example.proiect.dto.CustomerResponseDto;
import com.example.proiect.entities.Customer;
import com.example.proiect.services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable ("id") Long id) {
        return ResponseEntity.ok().body(customerService.getCustomerById(id));
    }
    @GetMapping()
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomers() {
        List<CustomerResponseDto>customers=customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
    @PostMapping()
    public String createCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        return customerService.createCustomer(customerRequestDto);
    }
    @PutMapping("/{id}")
    public String updateCustomer(@PathVariable ("id") Long id, @Valid @RequestBody CustomerRequestDto customer){
        customerService.updateCustomer(id,customer);
        return "Customer updated successfully";
    }
    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable ("id") Long id){
        customerService.deleteCustomer(id);
        return "customer deleted successfully";
    }

}