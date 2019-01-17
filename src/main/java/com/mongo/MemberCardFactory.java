package com.mongo;

import org.bson.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class MemberCardFactory {
    private static final String PERSON = "person";
    private static final String BOOKS = "books";
    private static final String NUMBER = "number";
    private static final String CREATION_DATE = "creation date";
    private static final String PENALTY = "penalty";
    private static final String VIP = "vip";
    public Document create(Document person, List<String> books, String number, Date date) {
        return new Document()
                .append(PERSON,person)
                .append(BOOKS,books)
                .append(NUMBER,number)
                .append(CREATION_DATE,date);

    }
    public Document create(Document person, List<String> books, String number, Date date, double penalty) {
        return new Document()
                .append(PERSON,person)
                .append(BOOKS,books)
                .append(NUMBER,number)
                .append(CREATION_DATE,date)
                .append(PENALTY, penalty);

    }
    public Document create(Document person, List<String> books, String number, Date date, boolean vip) {
        return new Document()
                .append(PERSON,person)
                .append(BOOKS,books)
                .append(NUMBER,number)
                .append(CREATION_DATE,date)
                .append(VIP, vip);
    }
}
