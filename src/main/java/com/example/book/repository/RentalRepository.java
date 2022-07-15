package com.example.book.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.example.book.entity.Rental;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RentalRepository {

    private final EntityManager em;
    
    public void save(Rental rental) {
        em.persist(rental);
    }

    public List<Rental> findAll() {
        return em.createQuery(
            "select r from Rental r" +
            " join fetch r.user u" +
            " join fetch r.book b", Rental.class)
            .getResultList();
    }
    
}
