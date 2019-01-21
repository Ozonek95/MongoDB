package com.mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.List;

public class BookMongoCRUD implements MongoCRUD {

    private MongoCollection<Document> collection;
    private BookFactory bookFactory;

    public BookMongoCRUD(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    public BookMongoCRUD(MongoCollection<Document> collection, BookFactory bookFactory) {
        this.collection = collection;
        this.bookFactory = bookFactory;
    }


    @Override
    public void addToDatabase(Document document) {
        collection.insertOne(document);
    }

    @Override
    public void addToDatabase(List<Document> documents) {
        collection.insertMany(documents);
    }

    @Override
    public void updateOne(String parameter,  Object valueBefore, Object newValue) {
        collection.updateOne(Filters.eq(parameter,valueBefore),Updates.set(parameter,newValue));
    }
    @Override
    public void updateOne(String parametr, Object parameterValue, String newParameter, Object newParameterValue){
        collection.updateOne(Filters.eq(parametr,parameterValue),Updates.set(newParameter,newParameterValue));
    }

    @Override
    public void updateMany(String parameter, Object valueBefore, Object newValue) {

        collection.updateMany(Filters.eq(parameter,valueBefore),Updates.set(parameter,newValue));
    }

    @Override
    public void updateMany(String parameter, Object parameterValue, String newParameterName, Object newParameterValue ) {

        collection.updateMany(Filters.eq(parameter,parameterValue),Updates.set(newParameterName,newParameterValue));
    }

    @Override
    public void deleteOne(String parameter, Object parameterValue) {
        collection.deleteOne(Filters.eq(parameter,parameterValue));
    }

    @Override
    public void deleteMany(String parameter, Object parameterValue) {

        collection.deleteMany(Filters.eq(parameter,parameterValue));
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
