package com.example.book.entity;

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

    private String name; //사용자 이름

    private Integer phoneNumber; //사용자 번호

    private String address; //사용자 주소

    private Integer registNumber; //주민등록번호
}
