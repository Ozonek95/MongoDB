package com.mongo;

import java.util.List;

public class Book {
    private String title;
    private String author;
    private List<String> categories;

    public Book(String title, String author, List<String> categories) {
        this.title = title;
        this.author = author;
        this.categories = categories;
    }
}
