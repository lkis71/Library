package com.example.book.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.book.controller.request.BookRequest;
import com.example.book.entity.Book;
import com.example.book.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BookService {

    private final BookRepository bookRepository;

    @Transactional
    public Book insert(BookRequest bookRequest) {

        Book book = Book.createBook(bookRequest.getTitle(), bookRequest.getStock(), bookRequest.getAuthor(), bookRequest.getLocation());
        bookRepository.save(book);
        
        return book;
    }
    
}
