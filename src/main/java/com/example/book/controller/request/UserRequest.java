package com.example.book.controller.request;

import lombok.Data;

@Data
public class UserRequest {
    
    private Long id;
    private String userNm;
    private String phoneNum;
    private String address; 
    private String registNum;
}
