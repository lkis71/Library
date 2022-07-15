package com.example.book.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.example.book.entity.Book;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BookRepository {

    private final EntityManager em;

    public void save(Book book) {
        em.persist(book);
    }

    public Optional<Book> findOne(Long bookId) {
        return em.createQuery("select b from Book b where id = :bookId", Book.class)
            .setParameter("bookId", bookId)
            .getResultList()
            .stream()
            .findAny();
    }

    
}
