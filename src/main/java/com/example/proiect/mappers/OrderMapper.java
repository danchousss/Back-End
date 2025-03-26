package com.example.proiect.mappers;


import com.example.proiect.dto.OrderRequestDto;
import com.example.proiect.dto.OrderResponseDto;
import com.example.proiect.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order toOrder(OrderRequestDto orderDto);

    OrderResponseDto toOrderDto(Order order);

    List<OrderRequestDto> toResponseList(List<Order> orders);




}
