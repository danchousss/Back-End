package com.example.proiect.mappers.impl;

import com.example.proiect.dto.OrderRequestDto;
import com.example.proiect.dto.OrderResponseDto;
import com.example.proiect.entities.Order;
import com.example.proiect.mappers.OrderMapper;

import java.util.List;

public class OrderMapperImpl implements OrderMapper {
    @Override
    public Order toOrder(OrderRequestDto orderDto) {
        if (orderDto == null) {
            return null;
        }

        Order order = new Order();
        order.setPrice(orderDto.getPrice());

        return order;
    }

    @Override
    public OrderResponseDto toOrderDto(Order order) {
        if (order == null) {
            return null;
        }

        OrderResponseDto orderDto = new OrderResponseDto();
        orderDto.setId(order.getId());
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
