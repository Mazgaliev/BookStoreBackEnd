package com.example.bookstorebackend.web.rest;

import com.example.bookstorebackend.model.Category;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/category")
public class CategoryRestController {


    @GetMapping
    public List<Category> findAll() {

        return new ArrayList<Category>(List.of(Category.values()));
    }
}
