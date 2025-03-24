package com.example.proiect.services;

import com.example.proiect.dto.OrderRequestDto;
import com.example.proiect.dto.OrderResponseDto;
import com.example.proiect.entities.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(Long id);
    List<OrderResponseDto> getAllOrders();
    String createOrder(OrderRequestDto order);
    void updateOrder(Long id, OrderRequestDto order);
    void deleteOrder(Long id);

}
