package com.flashsolution.lumierebeauty.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flashsolution.lumierebeauty.entity.Order;
import com.flashsolution.lumierebeauty.service.OrderService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController 
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping 
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
}
