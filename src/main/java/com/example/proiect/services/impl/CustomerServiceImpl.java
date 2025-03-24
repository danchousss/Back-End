package com.example.proiect.services.impl;

import com.example.proiect.dto.CustomerRequestDto;
import com.example.proiect.dto.CustomerResponseDto;
import com.example.proiect.entities.Customer;
import com.example.proiect.mappers.CustomerMapper;
import com.example.proiect.repositories.CustomerRepository;
import com.example.proiect.services.CustomerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }
    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + id));
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customerRepository.findAll().stream()
                .map(customerMapper::toCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public String createCustomer(CustomerRequestDto customerDto) {
        Customer savedCustomer = customerMapper.toCustomer(customerDto);
        if (savedCustomer == null) {
            throw new IllegalArgumentException("Customer entity is null after mapping!");
        }
        customerRepository.save(savedCustomer);
        return "Customer has been saved";
    }

    @Override
    public void updateCustomer(Long id, CustomerRequestDto customerDto) {
        Customer customerToUpdate = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + id));

        if (customerDto.getName() != null && !customerDto.getName().isBlank()) {
            customerToUpdate.setName(customerDto.getName());
        }
        customerToUpdate.setAddress(customerDto.getAddress());
        customerToUpdate.setPhone(customerDto.getPhone());

        customerRepository.save(customerToUpdate);

    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + id));
        customerRepository.deleteById(id);
    }
}
