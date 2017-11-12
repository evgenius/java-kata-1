package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.storage.AuthorStorage;
import org.echocat.kata.java.part1.storage.BookStorage;
import org.echocat.kata.java.part1.storage.MagazineStorage;

import java.io.IOException;

@SuppressWarnings("UseOfSystemOutOrSystemErr")
public class MainApp {

    public static void main(String[] args) throws IOException {
        AuthorStorage authorStorage = AuthorStorage.fromFile("authors.csv");
        BookStorage bookStorage = BookStorage.fromFile("books.csv", authorStorage);
        MagazineStorage magazineStorage = MagazineStorage.fromFile("magazines.csv", authorStorage);
        System.out.println(getHelloWorldText());
    }

    protected static String getHelloWorldText() {
        return "Hello world!";
    }

}
