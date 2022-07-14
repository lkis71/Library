package com.example.book.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;

@Entity
@Getter
public class Book {
    
    @Id @GeneratedValue
    @Column(name = "book_id")
    private Long id;

    private String title; //제목

    private Integer stock; //수량

    private Integer rentalPrice; //대여 금액

    private String author; //저자명

    private String location; //책 위치

    private LocalDateTime newDate; //책 반입 일자

    @OneToMany(mappedBy = "book")
    private List<Rental> rental = new ArrayList<>();

    public void setRental(Rental rental){
        this.rental.add(rental);
        rental.setBook(this);
    }
}
