package org.echocat.kata.java.part1.storage;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.echocat.kata.java.part1.data.CsvFile;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Book;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookStorage {

    private final AuthorStorage authorStorage;
    private Map<String, Book> map = new HashMap<>();

    public BookStorage(AuthorStorage authorStorage) {
        this.authorStorage = authorStorage;
    }

    public static BookStorage fromFile(String resourceName, AuthorStorage authorStorage) throws IOException {
        BookStorage storage = new BookStorage(authorStorage);
        InputStream io = CsvFile.getResource(resourceName);
        Iterable<CSVRecord> records = CSVFormat.newFormat(';')
                .withFirstRecordAsHeader()
                .parse(new InputStreamReader(io));

        for (CSVRecord record : records) {
            String title = record.get(0);
            String isbn = record.get(1);
            String description = record.get(3);

            String[] authorEmails = record.get(2).split(",");
            List<Author> authors = Stream.of(authorEmails).map(authorStorage::get).collect(Collectors.toList());

            Book book = new Book(title, isbn, description, authors);
            storage.add(book);
        }

        return storage;
    }

    private void add(Book book) {
        map.put(book.getIsbn(), book);
    }
}
