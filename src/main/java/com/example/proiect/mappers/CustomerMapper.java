package com.example.proiect.mappers;

import com.example.proiect.dto.CustomerDto;
import com.example.proiect.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toCustomer(CustomerDto customerDto);

    CustomerDto toCustomerDto(Customer customer);
    List<CustomerDto> toCustomerDtoList(List<Customer> customers);



}
