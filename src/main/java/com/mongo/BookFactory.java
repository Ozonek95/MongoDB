package com.mongo;

import org.bson.Document;

import java.util.Arrays;
import java.util.List;

public class BookFactory {
    public Document create(String title, String author, List<String> categories) {
        return new Document()
                .append("title",title)
                .append("author",author)
                .append("categories", categories);
    }
}
