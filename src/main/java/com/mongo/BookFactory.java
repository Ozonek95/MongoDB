package com.mongo;

import org.bson.Document;
import java.util.List;

public class BookFactory {
    private static final String TITLE = "title";
    private static final String AUTHOR = "author";
    private static final String CATEGORIES = "categories";
    public Document create(String title, String author, List<String> categories) {
        return new Document()
                .append(TITLE,title)
                .append(AUTHOR,author)
                .append(CATEGORIES, categories);
    }
}
