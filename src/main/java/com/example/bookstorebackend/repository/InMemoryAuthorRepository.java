package com.example.bookstorebackend.repository;

import com.example.bookstorebackend.dataholder.DataHolder;
import com.example.bookstorebackend.model.Author;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class InMemoryAuthorRepository {
    //TODO CREATE,READ,UPDATE,DELETE
    public List<Author> findAll() {
        return DataHolder.authors;
    }

    public Optional<Author> findById(Long id) {
        return DataHolder.authors.stream().filter(auth -> Objects.equals(auth.getId(), id)).findFirst();
    }
}
