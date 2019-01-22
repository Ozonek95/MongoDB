package com.mongo;

import java.util.Date;
import java.util.List;

public class MemberCard {
    private Person person;
    private List<String> books;
    private String number;
    private Date date;
    private String penalty;
    private boolean vip;

    public MemberCard(Person person, List<String> books, String number, Date date, String penalty, boolean vip) {
        this.person = person;
        this.books = books;
        this.number = number;
        this.date = date;
        this.penalty = penalty;
        this.vip = vip;
    }

    public MemberCard(Person person, List<String> books, String number, Date date) {
        this.person = person;
        this.books = books;
        this.number = number;
        this.date = date;
    }

    public Person getPerson() {
        return person;
    }

    public List<String> getBooks() {
        return books;
    }

    public String getNumber() {
        return number;
    }

    public Date getDate() {
        return date;
    }

    public String getPenalty() {
        return penalty;
    }

    public boolean isVip() {
        return vip;
    }
}
