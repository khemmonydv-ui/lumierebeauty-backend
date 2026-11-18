package com.flashsolution.lumierebeauty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashsolution.lumierebeauty.entity.Order;

public interface OrderRepository extends JpaRepository <Order, Long>{
    
}
