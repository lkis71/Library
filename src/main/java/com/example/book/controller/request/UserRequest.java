package com.example.book.controller.request;

import lombok.Data;

@Data
public class UserRequest {
    
    private String userNm;
    private String phoneNum;
    private String address;
    private Integer registNum;
}
