package com.example.bookstorebackend.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Book {

    @Id
    private Long id;

    private String name;
    @Enumerated(value = EnumType.STRING)
    private Category category;
    @ManyToOne
    private Author author;

    private Integer availableCopies;

    public Book(Long id, String name, Category category, Author author, Integer availableCopies) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
    }

    public Book() {

    }
}
