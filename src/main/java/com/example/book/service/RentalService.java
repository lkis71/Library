package com.example.book.service;

import java.util.List;
import java.util.Optional;

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

        Optional<User> user = userRepository.findOne(userId);

        Optional<Book> book = bookRepository.findOne(bookId);
        book.get().removeStock(1);
        
        Rental rental = new Rental();
        rental.createRental(user.get(), book.get());

        rentalRepository.save(rental);

        return rental.getId();
    }

    @Transactional
    public List<Rental> getRental() {
        return rentalRepository.findAll();
    }
}
