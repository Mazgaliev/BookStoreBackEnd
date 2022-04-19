package com.example.bookstorebackend.dataholder;

import com.example.bookstorebackend.model.Author;
import com.example.bookstorebackend.model.Book;
import com.example.bookstorebackend.model.Category;
import com.example.bookstorebackend.model.Country;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {

    public static List<Book> books = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();
    public static List<Country> countries = new ArrayList<>();


    @PostConstruct
    public void init() {
        for (int i = 0; i < 10; i++) {
            countries.add(new Country((long) i, "CountryName" + i, "ContinentName" + i));
        }

        for (int i = 0; i < 10; i++) {
            String name = "Author" + i;
            String surname = "AuthorSurname" + i;
            authors.add(new Author((long) i, name, surname, countries.get(i)));
        }

        for (int i = 0; i < 10; i++) {
            Category cat;
            if (i >= 7) {
                cat = Category.values()[i - 4];
            } else {
                cat = Category.values()[i];
            }
            Book b = new Book((long) i, "BookName" + i, cat, authors.get(i), (100 / (i + 1)) * 2);

            books.add(b);
        }
    }

}
