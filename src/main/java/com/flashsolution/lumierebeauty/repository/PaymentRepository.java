package com.flashsolution.lumierebeauty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashsolution.lumierebeauty.entity.Payment;

public interface PaymentRepository extends JpaRepository <Payment, Long>{
    
}
