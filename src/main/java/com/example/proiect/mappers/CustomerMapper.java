package com.example.proiect.mappers;

import com.example.proiect.dto.CustomerRequestDto;
import com.example.proiect.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    Customer toCustomer(CustomerRequestDto customerDto);

    CustomerRequestDto toCustomerDto(Customer customer);
    List<CustomerRequestDto> toCustomerDtoList(List<Customer> customers);



}
