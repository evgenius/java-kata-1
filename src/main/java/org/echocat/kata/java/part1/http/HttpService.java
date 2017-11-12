package org.echocat.kata.java.part1.http;

import org.echocat.kata.java.part1.storage.Storage;
import spark.Spark;

public class HttpService {

    private Storage storage;

    public HttpService(Storage storage) {
        this.storage = storage;
    }

    public void run() {
        Spark.port(8000);
        setupRoutes();
    }

    private void setupRoutes() {

        Spark.get("/status", (req, res) -> "ok");

        Spark.get("/books/isbn/:isbn", (req, res) -> {
            String isbn = req.params(":isbn");
            return storage.getBookByIsbn(isbn);
        });

        Spark.get("/magazines/isbn/:isbn", (req, res) -> {
            String isbn = req.params(":isbn");
            return storage.getMagazineByIsbn(isbn);
        });

        Spark.get("/books/author/:author", (req, res) -> {
            String authorEmail = req.params(":author");
            return storage.getBooksByAuthorEmail(authorEmail);
        });

        Spark.get("/magazines/author/:author", (req, res) -> {
            String authorEmail = req.params(":author");
            return storage.getMagazinesByAuthorEmail(authorEmail);
        });
    }
}
