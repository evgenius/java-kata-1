package org.echocat.kata.java.part1.model;

import java.util.Collections;
import java.util.List;

public class Book {

    private final String title;
    private final String isbn;
    private final String description;
    private final List<Author> authors;

    public Book(String title, String isbn, String description, List<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.description = description;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getDescription() {
        return description;
    }

    public List<Author> getAuthors() {
        return Collections.unmodifiableList(authors);
    }
}
