package com.example.bookstorebackend.repository;

import com.example.bookstorebackend.dataholder.DataHolder;
import com.example.bookstorebackend.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryBookRepository {
    //TODO CREATE,READ,UPDATE,DELETE
    public List<Book> findAll() {
        return DataHolder.books;
    }

    public Book save(Book book) {
        if (DataHolder.books.contains(book))
            return null;
        DataHolder.books.add(book);

        return book;
    }

    public Book findById(Long id) {

        return DataHolder.books.stream().filter(book -> book.getId().equals(id)).findFirst().orElse(null);
    }

    public Book delete(Book book) {

        DataHolder.books.removeIf(b -> b.equals(book));

        return book;
    }

}
