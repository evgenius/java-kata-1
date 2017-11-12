package org.echocat.kata.java.part1.model;

import java.util.Collections;
import java.util.List;

public class Book implements Document {

    private final String title;
    private final String isbn;
    private final String description;
    private final List<String> authorEmails;

    public Book(String title, String isbn, String description, List<String> authorEmails) {
        this.title = title;
        this.isbn = isbn;
        this.description = description;
        this.authorEmails = authorEmails;
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

    public List<String> getAuthorEmails() {
        return Collections.unmodifiableList(authorEmails);
    }
}
