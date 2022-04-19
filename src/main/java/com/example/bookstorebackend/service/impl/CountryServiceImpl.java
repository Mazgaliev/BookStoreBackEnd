package com.example.bookstorebackend.service.impl;

import com.example.bookstorebackend.model.Country;
import com.example.bookstorebackend.repository.InMemoryCountryRepository;
import com.example.bookstorebackend.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final InMemoryCountryRepository inMemoryCountryRepository;

    public CountryServiceImpl(InMemoryCountryRepository inMemoryCountryRepository) {
        this.inMemoryCountryRepository = inMemoryCountryRepository;
    }

    @Override
    public List<Country> findAll() {
        return inMemoryCountryRepository.findAll();
    }
}
