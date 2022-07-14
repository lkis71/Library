package com.example.book.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.book.entity.User;
import com.example.book.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    
    private final UserRepository userRepository;

    @Transactional
    public Long join(User user) {
        
        validateJoinUser(user);
        userRepository.save(user);
        return user.getId();
    }

    private void validateJoinUser(User user) {
        List<User> users = userRepository.findByRegistNumber(user.getRegistNumber());
        if(users.isEmpty()) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }
    }
}
