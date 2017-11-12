package org.echocat.kata.java.part1.storage;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.echocat.kata.java.part1.data.CsvFile;
import org.echocat.kata.java.part1.model.Author;
import org.echocat.kata.java.part1.model.Magazine;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MagazineStorage {

    private final AuthorStorage authorStorage;
    private Map<String, Magazine> map = new HashMap<>();

    public MagazineStorage(AuthorStorage authorStorage) {
        this.authorStorage = authorStorage;
    }

    public static MagazineStorage fromFile(String resourceName, AuthorStorage authorStorage) throws IOException {
        MagazineStorage storage = new MagazineStorage(authorStorage);
        InputStream io = CsvFile.getResource(resourceName);
        Iterable<CSVRecord> records = CSVFormat.newFormat(';')
                .withFirstRecordAsHeader()
                .parse(new InputStreamReader(io));

        for (CSVRecord record : records) {
            String title = record.get(0);
            String isbn = record.get(1);
            String publishedAt = record.get(3);

            String authorEmails = record.get(2);
            List<Author> authors = Stream.of(authorEmails).map(authorStorage::get).collect(Collectors.toList());

            Magazine magazine = new Magazine(title, isbn, publishedAt, authors);
            storage.add(magazine);
        }

        return storage;
    }

    private void add(Magazine magazine) {
        map.put(magazine.getIsbn(), magazine);
    }
}
