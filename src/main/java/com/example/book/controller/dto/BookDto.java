package com.example.book.controller.dto;

import com.example.book.entity.Book;

import lombok.Getter;

@Getter
public class BookDto {
    
    private Long id;
    private String title; //제목
    private Integer stock; //수량
    private String author; //저자명
    private String location; //책 위치

    public BookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.stock = book.getStock();
        this.author = book.getAuthor();
        this.location = book.getLocation();
    }
}
