package com.flashsolution.lumierebeauty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashsolution.lumierebeauty.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository <OrderItem, Long>{
    
}
