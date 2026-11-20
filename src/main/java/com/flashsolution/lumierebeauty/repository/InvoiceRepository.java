package com.flashsolution.lumierebeauty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashsolution.lumierebeauty.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
    
}
