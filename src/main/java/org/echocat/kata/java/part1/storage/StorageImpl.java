package org.echocat.kata.java.part1.storage;

import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Document;
import org.echocat.kata.java.part1.model.Magazine;

import java.io.IOException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StorageImpl implements Storage {

    private AuthorStorage authorStorage;
    private BookStorage bookStorage;
    private MagazineStorage magazineStorage;

    @Override
    public Book getBookByIsbn(String isbn) {
        return bookStorage.getByIsbn(isbn);
    }

    @Override
    public Magazine getMagazineByIsbn(String isbn) {
        return magazineStorage.getByIsbn(isbn);
    }

    @Override
    public Collection<Book> getAllBooks() {
        return bookStorage.getAll();
    }

    @Override
    public Collection<Magazine> getAllMagazines() {
        return magazineStorage.getAll();
    }

    @Override
    public List<Book> getBooksByAuthorEmail(String authorEmail) {
        return bookStorage.getByAuthorEmail(authorEmail);
    }

    @Override
    public List<Magazine> getMagazinesByAuthorEmail(String authorEmail) {
        return magazineStorage.getByAuthorEmail(authorEmail);
    }

    @Override
    public List<?> getAll() {
        return Stream.concat(bookStorage.getAll().stream(), magazineStorage.getAll().stream())
                .collect(Collectors.toList());
    }

    @Override
    public List<?> getAllSortedByTitle() {
        return Stream.concat(bookStorage.getAll().stream(), magazineStorage.getAll().stream())
                .sorted(Comparator.comparing(Document::getTitle))
                .collect(Collectors.toList());
    }

    public void load() throws IOException {
        authorStorage = AuthorStorage.fromFile("authors.csv");
        bookStorage = BookStorage.fromFile("books.csv");
        magazineStorage = MagazineStorage.fromFile("magazines.csv");

        bookStorage.createAuthorIndex();
        magazineStorage.createAuthorIndex();
    }
}
