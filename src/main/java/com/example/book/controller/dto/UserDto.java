package com.example.book.controller.dto;

import com.example.book.entity.User;

import lombok.Getter;

@Getter
public class UserDto {

    private Long id;
    private String userNm;
    private String phoneNum;
    private String address;
    private String registNum;

    public UserDto(User user) {
        this.id = user.getId();
        this.userNm = user.getUserNm();
        this.phoneNum = user.getPhoneNum();
        this.address = user.getAddress();
        this.registNum = user.getRegistNum();
    }
}
