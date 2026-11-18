package com.flashsolution.lumierebeauty.service;

import java.util.List;

import com.flashsolution.lumierebeauty.entity.Book;

public interface BookService {
    Book addBook(Book book);
    List<Book> getAllBooks();
}
