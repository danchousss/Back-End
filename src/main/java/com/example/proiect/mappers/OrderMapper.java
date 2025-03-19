package com.example.proiect.mappers;


import com.example.proiect.dto.OrderDto;
import com.example.proiect.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order toOrder(OrderDto orderDto);

    OrderDto toOrderDto(Order order);

    List<OrderDto> toOrderDtoList(List<Order> orders);




}
