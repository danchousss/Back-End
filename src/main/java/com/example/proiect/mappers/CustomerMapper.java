package com.example.proiect.mappers;

import com.example.proiect.dto.CustomerRequestDto;
import com.example.proiect.dto.CustomerResponseDto;
import com.example.proiect.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toCustomer(CustomerRequestDto customerDto);

    CustomerResponseDto toCustomerDto(Customer customer);
    List<CustomerRequestDto> toReponseList(List<Customer> customers);



}
