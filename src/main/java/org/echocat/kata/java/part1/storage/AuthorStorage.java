package org.echocat.kata.java.part1.storage;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.echocat.kata.java.part1.data.CsvFile;
import org.echocat.kata.java.part1.model.Author;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class AuthorStorage {

    private Map<String, Author> map = new HashMap<>();

    public static AuthorStorage fromFile(String resourceName) throws IOException {
        AuthorStorage storage = new AuthorStorage();
        InputStream io = CsvFile.getResource(resourceName);
        Iterable<CSVRecord> records = CSVFormat.newFormat(';')
                .withFirstRecordAsHeader()
                .parse(new InputStreamReader(io));

        for (CSVRecord record : records) {
            String email = record.get(0);
            String firstname = record.get(1);
            String lastname = record.get(2);
            Author author = new Author(email, firstname, lastname);
            storage.add(author);
        }

        return storage;
    }

    private void add(Author author) {
        map.put(author.getEmail(), author);
    }

    public Author get(String email) {
        return map.get(email);
    }
}
