package com.example.bookstorebackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Country {
    @Id
    private Long id;

    private String name;

    private String continent;

    public Country(Long id, String name, String continent) {
        this.id = id;
        this.name = name;
        this.continent = continent;
    }

    public Country() {

    }
}
