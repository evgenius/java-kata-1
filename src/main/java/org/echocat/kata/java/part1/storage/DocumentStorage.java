package org.echocat.kata.java.part1.storage;

import org.echocat.kata.java.part1.model.DocumentWithAuthors;
import org.echocat.kata.java.part1.model.DocumentWithIsbn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentStorage<E extends DocumentWithIsbn & DocumentWithAuthors> {
    private final Map<String, E> map = new HashMap<>();
    private Map<String, List<E>> authorIndex = new HashMap<>();

    public void add(E book) {
        map.put(book.getIsbn(), book);
    }

    public E getByIsbn(String isbn) {
        return map.get(isbn);
    }

    public List<E> getByAuthorEmail(String authorEmail) {
        return authorIndex.get(authorEmail);
    }

    public void createAuthorIndex() {
        authorIndex.clear();
        for (E book : map.values()) {
            for (String authorEmail : book.getAuthorEmails()) {
                authorIndex.compute(authorEmail, (k, v) -> {
                    if (v == null) v = new ArrayList<>();
                    v.add(book);
                    return v;
                });
            }
        }
    }
}
