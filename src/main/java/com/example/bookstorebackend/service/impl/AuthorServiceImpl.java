package com.example.bookstorebackend.service.impl;

import com.example.bookstorebackend.model.Author;
import com.example.bookstorebackend.repository.InMemoryAuthorRepository;
import com.example.bookstorebackend.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final InMemoryAuthorRepository inMemoryAuthorRepository;

    public AuthorServiceImpl(InMemoryAuthorRepository inMemoryAuthorRepository) {
        this.inMemoryAuthorRepository = inMemoryAuthorRepository;
    }

    @Override
    public List<Author> findAll() {
        return inMemoryAuthorRepository.findAll();
    }
}
