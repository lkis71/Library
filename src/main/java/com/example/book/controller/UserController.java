package com.example.book.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.book.controller.dto.UserDto;
import com.example.book.controller.request.UserRequest;
import com.example.book.entity.User;
import com.example.book.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public Map<String, Object> getUser(Model model) {
        List<User> users = userService.findAll();
        List<UserDto> userDtos = users.stream()
            .map(o -> new UserDto(o))
            .collect(Collectors.toList());
        model.addAttribute("users", users);

        Map<String, Object> result = new HashMap<>();
        result.put("data", userDtos);
        
        return result;
    }
    
    @PostMapping("/users")
    public Long createUser(@RequestBody UserRequest userRequest) {
        
        User user = new User();
        user.createUser(userRequest.getUserNm(), userRequest.getPhoneNum(), userRequest.getAddress(), userRequest.getRegistNum());

        return userService.join(user);
    }

    @PostMapping("/users/{userId}/edit")
    public void updateUser(@PathVariable("userId") Long userId, @RequestBody UserRequest userRequest) {

        User user = new User();
        // user.setId(userRequest.getId());
        user.createUser(userRequest.getUserNm(), userRequest.getPhoneNum(), userRequest.getAddress(), userRequest.getRegistNum());

        userService.update(user);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.delete(userId);
    }
}
