package com.example.bookstorebackend.service;

import com.example.bookstorebackend.model.Author;
import com.example.bookstorebackend.model.Book;
import com.example.bookstorebackend.model.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> saveBook(String name, Category category, Long authorId, Integer availableCopies);

    Book removeBook(Long id);

    Optional<Book> findByid(Long id);

    Optional<Book> editBook(Long id, String name, Category category, Long authorId, Integer availableCopies);
}
