package com.example.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.book.controller.dto.BookDto;
import com.example.book.controller.request.BookRequest;
import com.example.book.entity.Book;
import com.example.book.service.BookService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/books/new")
    public String createBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", new BookDto(book));
        return "book/bookForm";
    }

    @PostMapping("/books/new")
    public String createBook(BookRequest bookRequest) {
        bookService.insert(bookRequest);
        return "redirect:/books/new";
    }

    @GetMapping("/books/{bookId}/edit")
    public String updateBookForm(@PathVariable("bookId") Long bookId, Model model) {
        Book book = bookService.findOne(bookId);
        BookDto bookDto = new BookDto(book);
        model.addAttribute("book", bookDto);

        return "redirect:/books/new";
    }
}
