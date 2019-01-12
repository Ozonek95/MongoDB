package com.mongo;

import org.bson.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class MemberCardFactory {
    public Document create(Document person, List<String> books, String number, Date date) {
        return new Document()
                .append("person",person)
                .append("books",books)
                .append("number",number)
                .append("creation date",date);

    }
    public Document create(Document person, List<String> books, String number, Date date, double penalty) {
        return new Document()
                .append("person",person)
                .append("books",books)
                .append("number",number)
                .append("creation date",date)
                .append("penalty", penalty);

    }
    public Document create(Document person, List<String> books, String number, Date date, boolean vip) {
        return new Document()
                .append("person",person)
                .append("books",books)
                .append("number",number)
                .append("creation date",date)
                .append("vip", vip);
    }
}
