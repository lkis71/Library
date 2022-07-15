package com.example.book.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Book {
    
    @Id @GeneratedValue
    @Column(name = "book_id")
    private Long id;

    private String title; //제목

    private Integer stock; //수량

    private String author; //저자명

    private String location; //책 위치

    private LocalDateTime newDate; //책 반입 일자

    @OneToMany(mappedBy = "book")
    private List<Rental> rental = new ArrayList<>();

    public void setRental(Rental rental){
        this.rental.add(rental);
        rental.setBook(this);
    }

    /** 생성메서드 */
    public Book createBook(String title, int stock, String author, String location) {
        
        Book book = new Book();
        book.setTitle(title);
        book.setStock(stock);
        book.setAuthor(author);
        book.setLocation(location);
        book.setNewDate(LocalDateTime.now());

        return book;
    }

    //재고감소
    public void removeStock(int quantity) {
        int stock = this.stock - quantity;
        this.stock = stock;
    }
}
