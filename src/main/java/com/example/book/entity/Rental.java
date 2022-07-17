package com.example.book.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Rental {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rental_id")
    private Long id;

    private LocalDateTime rentalStartDate; //예약 시작시간
    
    private LocalDateTime rentalEndDate; //예약 종료시간

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    /** 생성메서드 */
    public static Rental createRental(User user, Book book) {
        
        Rental rental = new Rental();
        rental.setRentalStartDate(LocalDateTime.now());
        rental.setRentalEndDate(LocalDateTime.now().plusHours(6));
        rental.setUser(user);
        rental.setBook(book);

        return rental;
    }
}
