package com.example.bookstorebackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Author {
    @Id
    private Long id;

    private String what;

    private String name;

    private String surname;
    @ManyToOne
    private Country country;

    public Author(Long id, String name, String surname, Country country) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

    public Author() {

    }
}
