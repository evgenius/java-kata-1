package org.echocat.kata.java.part1.model;

import java.util.Collections;
import java.util.List;

public class Magazine implements Document {
    private final String title;
    private final String isbn;
    private final String publishedAt;
    private final List<String> authorEmails;

    public Magazine(String title, String isbn, String publishedAt, List<String> authorEmails) {
        this.title = title;
        this.isbn = isbn;
        this.publishedAt = publishedAt;
        this.authorEmails = authorEmails;
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

    public List<String> getAuthorEmails() {
        return Collections.unmodifiableList(authorEmails);
    }
}
