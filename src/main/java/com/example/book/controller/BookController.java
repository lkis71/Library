package com.example.book.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

    @GetMapping("/books")
    public String list(Model model) {
        List<Book> books = bookService.findAll();
        List<BookDto> bookDto = books.stream()
            .map(o -> new BookDto(o))
            .collect(Collectors.toList());
        model.addAttribute("books", bookDto);

        return "book/bookList";
    }
    

    @GetMapping("/books/new")
    public String createBookForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", new BookDto(book));
        return "book/bookForm";
    }

    @PostMapping("/books/new")
    public String createBook(BookRequest bookRequest) {
        bookService.insert(bookRequest);
        return "redirect:/books";
    }

    @GetMapping("/books/{bookId}/edit")
    public String updateBookForm(@PathVariable("bookId") Long bookId, Model model) {
        Book book = bookService.findOne(bookId);
        BookDto bookDto = new BookDto(book);
        model.addAttribute("book", bookDto);

        return "book/bookForm";
    }

    @PostMapping("/books/{bookId}/edit")
    public String updateBook(@PathVariable("bookId") Long bookId, BookRequest bookRequest) {
        bookService.update(bookId, bookRequest);
        return "redirect:/books";
    }
}
