package com.example.bookstorebackend.repository;

import com.example.bookstorebackend.dataholder.DataHolder;
import com.example.bookstorebackend.model.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryCountryRepository {
    //TODO CREATE,READ,UPDATE,DELETE
    public List<Country> findAll() {
        return DataHolder.countries;
    }

    public Country save(Country country) {
        if (DataHolder.countries.contains(country))
            return null;
        DataHolder.countries.add(country);
        return country;
    }

}
