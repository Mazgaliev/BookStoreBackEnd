package com.example.bookstorebackend.web.rest;


import com.example.bookstorebackend.model.Author;
import com.example.bookstorebackend.model.Book;
import com.example.bookstorebackend.model.Category;
import com.example.bookstorebackend.service.BookService;
import org.apache.coyote.Request;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = {"/", "/books"})
public class BookRestController {
    //TODO CREATE,READ,UPDATE,DELETE

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        this.bookService.removeBook(id);
        if (this.bookService.findByid(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findByid(id).map(book -> ResponseEntity.ok().body(book)).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestParam String name,
                                         @RequestParam Category category,
                                         @RequestParam Long author,
                                         @RequestParam Integer availableCopies) {
        return this.bookService.editBook(id, name, category, author, availableCopies)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @PostMapping("/add")
    public ResponseEntity<Book> addBook(
            @RequestParam() String name,
            @RequestParam() Category category,
            @RequestParam() Long author,
            @RequestParam() Integer availableCopies) {
        return this.bookService.saveBook(name, category, author, availableCopies)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.badRequest().build());

    }
}
