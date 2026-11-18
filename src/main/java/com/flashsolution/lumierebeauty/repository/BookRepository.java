package com.flashsolution.lumierebeauty.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flashsolution.lumierebeauty.entity.Book;

public interface BookRepository extends JpaRepository <Book, Long> {

}
