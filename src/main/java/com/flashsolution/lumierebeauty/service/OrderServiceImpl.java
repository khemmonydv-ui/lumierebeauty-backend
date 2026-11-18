package com.flashsolution.lumierebeauty.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.flashsolution.lumierebeauty.entity.Order;
import com.flashsolution.lumierebeauty.repository.OrderRepository;

@Service 
public class OrderServiceImpl implements OrderService{
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override 
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
