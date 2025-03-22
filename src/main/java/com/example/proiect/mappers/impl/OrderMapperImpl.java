package com.example.proiect.mappers.impl;

import com.example.proiect.dto.OrderRequestDto;
import com.example.proiect.dto.OrderResponseDto;
import com.example.proiect.entities.Customer;
import com.example.proiect.entities.Order;
import com.example.proiect.entities.Phone;
import com.example.proiect.mappers.OrderMapper;
import com.example.proiect.repositories.CustomerRepository;
import com.example.proiect.repositories.PhoneRepository;

import java.util.List;

public class OrderMapperImpl implements OrderMapper {
    private final PhoneRepository phoneRepository;
    private final CustomerRepository customerRepository;

    public OrderMapperImpl(PhoneRepository phoneRepository, CustomerRepository customerRepository) {
        this.phoneRepository = phoneRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Order toOrder(OrderRequestDto orderDto) {
        if (orderDto == null) {
            return null;
        }

        Order order = new Order();
        order.setPrice(orderDto.getPrice());

        Phone phone = phoneRepository.findById(orderDto.getPhone_id())
                .orElseThrow(() -> new RuntimeException("Phone not found"));
        order.setPhones(phone);

        Customer customer = customerRepository.findById(orderDto.getCustomer_id())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        order.setCustomer(customer);

        return order;
    }

    @Override
    public OrderResponseDto toOrderDto(Order order) {
        if (order == null) {
            return null;
        }

        OrderResponseDto orderDto = new OrderResponseDto();
        orderDto.setPrice(order.getPrice());
        orderDto.setPhone_id(order.getPhones().getId());
        orderDto.setCustomer_id(order.getCustomer().getId());


        return orderDto;
    }

    @Override
    public List<OrderRequestDto> toResponseList(List<Order> orders) {
        return List.of();
    }
}
