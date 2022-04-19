package com.example.bookstorebackend.service.impl;


import com.example.bookstorebackend.model.Author;
import com.example.bookstorebackend.model.Book;
import com.example.bookstorebackend.model.Category;
import com.example.bookstorebackend.repository.InMemoryAuthorRepository;
import com.example.bookstorebackend.repository.InMemoryBookRepository;
import com.example.bookstorebackend.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final InMemoryBookRepository inMemoryBookRepository;
    private final InMemoryAuthorRepository inMemoryAuthorRepository;

    public BookServiceImpl(InMemoryBookRepository inMemoryBookRepository, InMemoryAuthorRepository inMemoryAuthorRepository) {
        this.inMemoryBookRepository = inMemoryBookRepository;
        this.inMemoryAuthorRepository = inMemoryAuthorRepository;
    }

    @Override
    public List<Book> findAll() {
        return inMemoryBookRepository.findAll();
    }

    @Override
    public Optional<Book> saveBook(String name, Category category, Long authorId, Integer availableCopies) {
        Author a = inMemoryAuthorRepository.findById(authorId).orElse(null);
        return Optional.ofNullable(inMemoryBookRepository.save(new Book((long) (inMemoryBookRepository.findAll().size() + 1), name, category, a, availableCopies)));
    }

    @Override
    public Book removeBook(Long id) {
        Book b = inMemoryBookRepository.findById(id);
        inMemoryBookRepository.delete(b);
        return b;
    }

    @Override
    public Optional<Book> findByid(Long id) {
        return Optional.ofNullable(inMemoryBookRepository.findById(id));
    }

    @Override
    public Optional<Book> editBook(Long id, String name, Category category, Long authorId, Integer availableCopies) {
        Book book = this.inMemoryBookRepository.findById(id);
        Author author = this.inMemoryAuthorRepository.findById(authorId).orElse(null);
        book.setName(name);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        book.setCategory(category);
        return Optional.of(this.inMemoryBookRepository.save(book));
    }
}
