package com.flashsolution.lumierebeauty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashsolution.lumierebeauty.entity.User;

public interface UserRepository extends JpaRepository <User, Long>{
    
}
