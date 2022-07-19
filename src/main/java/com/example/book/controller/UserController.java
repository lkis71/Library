package com.example.book.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.book.controller.dto.UserDto;
import com.example.book.controller.request.UserRequest;
import com.example.book.entity.User;
import com.example.book.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public String list(Model model) {
        List<User> users = userService.findAll();
        List<UserDto> userDto = users.stream()
            .map(o -> new UserDto(o))
            .collect(Collectors.toList());
        model.addAttribute("users", userDto);
        
        return "user/userList";
    }
    
    @GetMapping("/users/new")
    public String createUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", new UserDto(user));
        return "user/userForm";
    }

    @PostMapping("/users/new")
    public String createUser(UserRequest userRequest) {
        
        User user = User.createUser(userRequest.getUserNm(), userRequest.getPhoneNum(), userRequest.getAddress(), userRequest.getRegistNum());
        userService.join(user);
        
        return "redirect:/users";
    }
    
    @GetMapping("users/{userId}/edit")
    public String updateUserForm(@PathVariable("userId") Long userId, Model model) {

        User user = userService.findOne(userId);
        UserDto userDto = new UserDto(user);
        model.addAttribute("user", userDto);

        return "user/userForm";
    }

    @PostMapping("/users/{userId}/edit")
    public String updateUser(@PathVariable("userId") Long userId, UserRequest userRequest) {

        User user = User.createUser(userRequest.getUserNm(), userRequest.getPhoneNum(), userRequest.getAddress(), userRequest.getRegistNum());
        user.setId(userId);

        userService.update(user);

        return "redirect:/users";
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.delete(userId);
    }
}
