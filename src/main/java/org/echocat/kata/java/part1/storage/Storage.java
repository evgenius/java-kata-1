package org.echocat.kata.java.part1.storage;

import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;

import java.util.Collection;
import java.util.List;

public interface Storage {
    Book getBookByIsbn(String isbn);
    Magazine getMagazineByIsbn(String isbn);
    Collection<Book> getAllBooks();
    Collection<Magazine> getAllMagazines();
    List<Book> getBooksByAuthorEmail(String authorEmail);
    List<Magazine> getMagazinesByAuthorEmail(String authorEmail);
}
