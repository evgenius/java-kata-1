package org.echocat.kata.java.part1.data;

import java.io.InputStream;

public class CsvFile {
    public static InputStream getResource(String name) {
        return CsvFile.class.getResourceAsStream(name);
    }
}
