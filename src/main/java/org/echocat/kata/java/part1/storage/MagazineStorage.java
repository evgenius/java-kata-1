package org.echocat.kata.java.part1.storage;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.echocat.kata.java.part1.data.CsvFile;
import org.echocat.kata.java.part1.model.Magazine;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class MagazineStorage extends DocumentStorage<Magazine> {

    public static MagazineStorage fromFile(String resourceName) throws IOException {
        MagazineStorage storage = new MagazineStorage();
        InputStream io = CsvFile.getResource(resourceName);
        Iterable<CSVRecord> records = CSVFormat.newFormat(';')
                .withFirstRecordAsHeader()
                .parse(new InputStreamReader(io));

        for (CSVRecord record : records) {
            String title = record.get(0);
            String isbn = record.get(1);
            List<String> authors = Arrays.asList(record.get(2).split(","));
            String publishedAt = record.get(3);

            Magazine magazine = new Magazine(title, isbn, publishedAt, authors);
            storage.add(magazine);
        }

        return storage;
    }
}
