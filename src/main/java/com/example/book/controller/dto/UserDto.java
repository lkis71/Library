package com.example.book.controller.dto;

import com.example.book.entity.User;

import lombok.Getter;

@Getter
public class UserDto {

    private String userNm;
    private String phoneNum;
    private String address;
    private Integer registNum;

    public UserDto(User user) {
        this.userNm = user.getUserNm();
        this.phoneNum = user.getPhoneNum();
        this.address = user.getAddress();
        this.registNum = user.getRegistNum();
    }
}
