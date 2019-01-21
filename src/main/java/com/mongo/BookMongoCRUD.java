package com.mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.List;

public class BookMongoCRUD {

    private MongoCollection<Document> collection;
    private BookFactory bookFactory;

    public BookMongoCRUD(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public BookMongoCRUD(MongoCollection<Document> collection, BookFactory bookFactory) {
        this.collection = collection;
        this.bookFactory = bookFactory;
    }


    public void addToDatabase(Document document) {
        collection.insertOne(document);
    }


    public void addToDatabase(List<Document> documents) {
        collection.insertMany(documents);
    }


    public void updateOne(String parameter,  Object valueBefore, Object newValue) {
        collection.updateOne(Filters.eq(parameter,valueBefore),Updates.set(parameter,newValue));
    }

    public void updateOne(String parametr, Object parameterValue, String newParameter, Object newParameterValue){
        collection.updateOne(Filters.eq(parametr,parameterValue),Updates.set(newParameter,newParameterValue));
    }


    public void updateMany(String parameter, Object valueBefore, Object newValue) {

        collection.updateMany(Filters.eq(parameter,valueBefore),Updates.set(parameter,newValue));
    }


    public void updateMany(String parameter, Object parametrValue, String newParameterName, Object newParameterValue ) {

        collection.updateMany(Filters.eq(parameter,parametrValue),Updates.set(newParameterName,newParameterValue));
    }

    public void addToDatabase(String title,String author, List<String> categories){
        Document book = bookFactory.create(title, author, categories);
        collection.insertOne(book);
    }

    public void addToDatabase(Book book){
        Document bookDocument = bookFactory.create(book.getTitle(),book.getAuthor(),book.getCategories());
        collection.insertOne(bookDocument);
    }



}
