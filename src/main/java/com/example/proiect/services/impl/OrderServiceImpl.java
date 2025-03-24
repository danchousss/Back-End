package com.example.proiect.services.impl;

import com.example.proiect.dto.OrderRequestDto;
import com.example.proiect.dto.OrderResponseDto;
import com.example.proiect.entities.Company;
import com.example.proiect.entities.Customer;
import com.example.proiect.entities.Order;
import com.example.proiect.entities.Phone;
import com.example.proiect.mappers.CustomerMapper;
import com.example.proiect.mappers.OrderMapper;
import com.example.proiect.mappers.PhoneMapper;
import com.example.proiect.repositories.CustomerRepository;
import com.example.proiect.repositories.OrderRepository;
import com.example.proiect.repositories.PhoneRepository;
import com.example.proiect.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
    private final PhoneRepository phoneRepository;
    private final PhoneMapper phoneMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, CustomerMapper customerMapper, CustomerRepository customerRepository, PhoneRepository phoneRepository, PhoneMapper phoneMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
        this.phoneRepository = phoneRepository;
        this.phoneMapper = phoneMapper;
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));

    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orderRepository.findAll().stream()
                .map(orderMapper::toOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public String createOrder(OrderRequestDto orderDto) {
        Order savedOrder = orderMapper.toOrder(orderDto);
        if(savedOrder == null){
            throw new RuntimeException("Order not found");
        }
        orderRepository.save(savedOrder);
        return "Order has been saved";
    }

    @Override
    public void updateOrder(Long id, OrderRequestDto orderDto) {
        Order orderToUpdate = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        Customer costumer = customerRepository.findById(orderDto.getCustomer_id())
                .orElseThrow(() -> new RuntimeException("Company not found with id " + orderDto.getCustomer_id()));
        Phone phone = phoneRepository.findById(orderDto.getPhone_id())
                .orElseThrow(() -> new RuntimeException("Company not found with id " + orderDto.getPhone_id()));
        orderToUpdate.setCustomer(costumer);
        orderToUpdate.setPrice(orderDto.getPrice());
        orderToUpdate.setPhones(phone);
        orderRepository.save(orderToUpdate);
    }


    @Override
    public void deleteOrder(Long id) {
        orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderRepository.deleteById(id);

    }
}
