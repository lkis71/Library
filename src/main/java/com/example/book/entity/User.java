package com.example.book.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "users")
public class User {
    
    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private String userNm; //사용자 이름

    private String phoneNum; //사용자 번호

    private String address; //사용자 주소

    private Integer registNum; //주민등록번호

    private LocalDateTime joinDate; //가입일자
    
    private String useAt; //회원탈퇴 여부

}
