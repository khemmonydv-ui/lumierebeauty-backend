package com.flashsolution.lumierebeauty.service;

import java.util.List;

import com.flashsolution.lumierebeauty.entity.Order;

public interface OrderService {
    Order addOrder(Order order)
    List<Order> getAllOrders();
}
