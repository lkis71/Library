package com.example.book.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;

@Entity
@Getter
@Table(name = "seat")
public class Seat {
    
    @Id @GeneratedValue
    @Column(name = "seat_id")
    private Long id;

    private String seatCd; //자리번호

    private String status; //예약상태

    private LocalDateTime reservStartDate; //예약 시작시간
    
    private LocalDateTime reservEndDate; //예약 종료시간

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
