package com.flashsolution.lumierebeauty.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flashsolution.lumierebeauty.entity.Book;
import com.flashsolution.lumierebeauty.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping 
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping 
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}
