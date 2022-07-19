package com.example.book.service;

import java.util.List;

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

    @Transactional
    public Book findOne(Long bookId) {
        return bookRepository.findOne(bookId);
    }
    
    @Transactional
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Transactional
    public void update(Long bookId, BookRequest bookRequest) {
        Book book = bookRepository.findOne(bookId);
        book.setTitle(bookRequest.getTitle());
        book.setStock(bookRequest.getStock());
        book.setAuthor(bookRequest.getAuthor());
        book.setLocation(bookRequest.getLocation());
    }
    
}
