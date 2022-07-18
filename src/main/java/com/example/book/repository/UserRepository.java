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

    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class)
            .getResultList();
    }

    public void save(User user) {
        if(user.getId() == null){
            em.persist(user);
        }else{
            em.merge(user);
        }
    }
    
    public List<User> findByRegistNum(String registNum) {
        return em.createQuery("select u from User u where registNum = :registNum", User.class)
            .setParameter("registNum", registNum)
            .getResultList();
    }

    public User findOne(Long userId){
        return em.find(User.class, userId);
    }

}
