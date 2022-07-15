package com.example.book.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.controller.request.BookRequest;
import com.example.book.entity.Book;
import com.example.book.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping("/books")
    public Long insertBook(BookRequest bookrequest) {

        Book book = new Book();
        book.createBook(bookrequest.getTitle(), bookrequest.getStock(), bookrequest.getAuthor(), bookrequest.getLocation());

        return bookService.insert(book);
    }
    
}
