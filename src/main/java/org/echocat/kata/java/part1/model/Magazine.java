package org.echocat.kata.java.part1.model;

import java.util.Collections;
import java.util.List;

public class Magazine {
    private final String title;
    private final String isbn;
    private final String publishedAt;
    private final List<Author> authors;

    public Magazine(String title, String isbn, String publishedAt, List<Author> authors) {
        this.title = title;
        this.isbn = isbn;
        this.publishedAt = publishedAt;
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public List<Author> getAuthors() {
        return Collections.unmodifiableList(authors);
    }
}
