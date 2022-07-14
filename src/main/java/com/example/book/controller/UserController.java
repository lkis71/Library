package com.example.book.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.controller.vo.UserVo;
import com.example.book.entity.User;
import com.example.book.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    
    @PostMapping("/users/join")
    public Long createUser(@RequestBody UserVo userVo) {
        
        User user = new User();
        user.setName(userVo.getName());
        user.setPhoneNumber(userVo.getPhoneNumber());
        user.setAddress(userVo.getAddress());

        return userService.join(user);
    }
}
