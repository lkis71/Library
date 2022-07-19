package com.example.book.repository;

import java.util.List;

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

    public Book findOne(Long bookId) {
        return em.find(Book.class, bookId);
    }

    public List<Book> findAll() {
        return em.createQuery("select b from Book b", Book.class)
            .getResultList();
    }
}
