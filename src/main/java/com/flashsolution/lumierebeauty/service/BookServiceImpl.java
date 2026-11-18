package com.flashsolution.lumierebeauty.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.flashsolution.lumierebeauty.repository.BookRepository;
import com.flashsolution.lumierebeauty.entity.Book;

@Service 
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override 
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override 
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
