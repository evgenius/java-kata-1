package org.echocat.kata.java.part1.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.echocat.kata.java.part1.storage.Storage;
import spark.Spark;

public class HttpService {

    private Storage storage;
    private Gson gson = new GsonBuilder().create();

    public HttpService(Storage storage) {
        this.storage = storage;
    }

    public void run() {
        Spark.port(8000);
        setupRoutes();
    }

    private void setupRoutes() {

        Spark.get("/status", (req, res) -> "ok");

        Spark.get("/", (req, res) ->
                "<a href=\"/books\">All books</a><br />" +
                "<a href=\"/books/isbn/5554-5545-4518\">Example book</a><br />" +
                "<a href=\"/books/author/null-rabe@echocat.org\">All books by null-rabe@echocat.org</a><br />" +
                "<a href=\"/magazines\">All magazines</a><br />" +
                "<a href=\"/magazines/isbn/2547-8548-2541\">Example magazine</a><br />" +
                "<a href=\"/magazines/author/null-walter@echocat.org\">All magazines by null-walter@echocat.org</a><br />" +
                "<a href=\"/all\">All books and magazines</a><br />" +
                "<a href=\"/all/sorted\">All books and magazines sorted by title</a><br />");

        Spark.get("/books", (req, res) -> {
            return storage.getAllBooks();
        }, gson::toJson);

        Spark.get("/books/isbn/:isbn", (req, res) -> {
            String isbn = req.params(":isbn");
            return storage.getBookByIsbn(isbn);
        }, gson::toJson);

        Spark.get("/books/author/:author", (req, res) -> {
            String authorEmail = req.params(":author");
            return storage.getBooksByAuthorEmail(authorEmail);
        }, gson::toJson);

        Spark.get("/magazines", (req, res) -> {
            return storage.getAllMagazines();
        }, gson::toJson);

        Spark.get("/magazines/isbn/:isbn", (req, res) -> {
            String isbn = req.params(":isbn");
            return storage.getMagazineByIsbn(isbn);
        }, gson::toJson);

        Spark.get("/magazines/author/:author", (req, res) -> {
            String authorEmail = req.params(":author");
            return storage.getMagazinesByAuthorEmail(authorEmail);
        }, gson::toJson);

        Spark.get("/all", (req, res) -> {
            return storage.getAll();
        }, gson::toJson);

        Spark.get("/all/sorted", (req, res) -> {
            return storage.getAllSortedByTitle();
        }, gson::toJson);
    }
}
