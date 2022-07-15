package com.example.book.controller.request;

import lombok.Data;

@Data
public class BookRequest {
    
    private String title;
    private Integer stock;
    private String author;
    private String location;
}
