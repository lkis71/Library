package com.example.book.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.book.entity.Book;
import com.example.book.entity.Rental;
import com.example.book.entity.User;
import com.example.book.repository.BookRepository;
import com.example.book.repository.RentalRepository;
import com.example.book.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RentalService {

    private final RentalRepository rentalRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    //책 대여
    @Transactional
    public Long rental(Long userId, Long bookId) {

        User user = userRepository.findOne(userId);

        Book book = bookRepository.findOne(bookId);
        book.removeStock(1);
        
        Rental rental = new Rental();
        rental.createRental(user, book);

        rentalRepository.save(rental);

        return rental.getId();
    }

    @Transactional
    public List<Rental> getRental() {
        return rentalRepository.findAll();
    }
}
