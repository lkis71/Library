package com.example.book.controller.dto;

import java.time.LocalDateTime;

import com.example.book.entity.Book;
import com.example.book.entity.Rental;
import com.example.book.entity.User;

import lombok.Getter;

@Getter
public class RentalDto {

    private LocalDateTime rentalStartDate;
    private LocalDateTime rentalEndDate;
    private User user;
    private Book book;

    public RentalDto(Rental rental) {
        this.rentalStartDate = rental.getRentalStartDate();
        this.rentalEndDate = rental.getRentalEndDate();
        this.user = rental.getUser();
        this.book = rental.getBook();
    }
    
}
