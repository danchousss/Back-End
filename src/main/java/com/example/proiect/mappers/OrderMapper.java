package com.example.proiect.mappers;


import com.example.proiect.dto.OrderRequestDto;
import com.example.proiect.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toOrder(OrderRequestDto orderDto);

    OrderRequestDto toOrderDto(Order order);

    List<OrderRequestDto> toOrderDtoList(List<Order> orders);




}
