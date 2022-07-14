package com.example.book.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.example.book.entity.User;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    
    private final EntityManager em;

    public void save(User user) {
        em.persist(user);
    }
    
    public List<User> findByRegistNumber(Integer registNumber) {
        return em.createQuery("select u from User u where registNumber = :registNumber", User.class)
            .setParameter("registNumber", registNumber)
            .getResultList();
    }
}
