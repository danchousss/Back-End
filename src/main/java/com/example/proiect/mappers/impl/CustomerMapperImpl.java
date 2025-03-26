package com.example.proiect.mappers.impl;

import com.example.proiect.dto.CustomerRequestDto;
import com.example.proiect.dto.CustomerResponseDto;
import com.example.proiect.entities.Customer;
import com.example.proiect.mappers.CustomerMapper;

import java.util.List;

public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public Customer toCustomer(CustomerRequestDto customerDto) {
            if (customerDto == null) {
                return null;
            }

            Customer customer = new Customer();
            customer.setName(customerDto.getName());
            customer.setAddress(customerDto.getAddress());
            customer.setPhone(customerDto.getPhone());

            return customer;
    }

    @Override
    public CustomerResponseDto toCustomerDto(Customer customer) {
        if (customer == null) {
            return null;
        }

        CustomerResponseDto customerDto = new CustomerResponseDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setAddress(customer.getAddress());
        customerDto.setPhone(customer.getPhone());
        return customerDto;
    }

    @Override
    public List<CustomerRequestDto> toReponseList(List<Customer> customers) {
        return List.of();
    }
}
