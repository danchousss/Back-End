package com.example.proiect.services;

import com.example.proiect.entities.Order;

import java.util.List;

public interface OrderService {
    Order getOrderById(Long id);
    List<Order> getAllOrders();
    Order createOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrder(Long id);
}
