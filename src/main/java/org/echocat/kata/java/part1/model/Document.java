package org.echocat.kata.java.part1.model;

import java.util.List;

public interface Document {
    String getIsbn();
    String getTitle();
    List<String> getAuthorEmails();
}
