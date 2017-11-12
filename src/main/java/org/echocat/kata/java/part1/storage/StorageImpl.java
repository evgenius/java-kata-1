package org.echocat.kata.java.part1.storage;

import org.echocat.kata.java.part1.model.Book;
import org.echocat.kata.java.part1.model.Magazine;

import java.io.IOException;
import java.util.List;

public class StorageImpl implements Storage {

    private AuthorStorage authorStorage;
    private BookStorage bookStorage;
    private MagazineStorage magazineStorage;

    public Book getBookByIsbn(String isbn) {
        return bookStorage.getByIsbn(isbn);
    }

    public Magazine getMagazineByIsbn(String isbn) {
        return magazineStorage.getByIsbn(isbn);
    }

    @Override
    public List<Book> getBooksByAuthorEmail(String authorEmail) {
        return bookStorage.getByAuthorEmail(authorEmail);
    }

    @Override
    public List<Magazine> getMagazinesByAuthorEmail(String authorEmail) {
        return magazineStorage.getByAuthorEmail(authorEmail);
    }

    public void load() throws IOException {
        authorStorage = AuthorStorage.fromFile("authors.csv");
        bookStorage = BookStorage.fromFile("books.csv");
        magazineStorage = MagazineStorage.fromFile("magazines.csv");

        bookStorage.createAuthorIndex();
        magazineStorage.createAuthorIndex();
    }
}
