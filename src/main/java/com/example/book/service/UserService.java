package com.example.book.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.book.controller.request.UserRequest;
import com.example.book.entity.User;
import com.example.book.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    
    private final UserRepository userRepository;

    //회원 조회
    public User findOne(Long userId) {
        return userRepository.findOne(userId);
    }
    
    //회원 전체조회
    public List<User> findAll() {
        return userRepository.findAll();
    }

    //회원등록
    @Transactional
    public Long join(User user) {
        
        validateJoinUser(user);
        userRepository.save(user);
        return user.getId();
    }

    //회원가입여부 체크
    private void validateJoinUser(User user) {
        List<User> users = userRepository.findByRegistNum(user.getRegistNum());
        if(!users.isEmpty()) {
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
        }
    }

    //회원수정
    @Transactional
    public void update(Long userId, UserRequest userRequest) {
        User user = userRepository.findOne(userId);
        user.setUserNm(userRequest.getUserNm());
        user.setPhoneNum(userRequest.getPhoneNum());
        user.setAddress(userRequest.getAddress());
        user.setRegistNum(userRequest.getRegistNum());
    }

    //회원탈퇴
    @Transactional
    public void delete(Long userId) {
        User user = userRepository.findOne(userId);
        user.setUseAt("N");
        userRepository.save(user);
    }

}
