package com.example.task.controller;

import com.example.task.api.BookCreationRequest;
import com.example.task.model.Book;
import com.example.task.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public Book create(@RequestBody BookCreationRequest request) { return bookService.create(request); }

    @DeleteMapping(value = "/{id}" )
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}