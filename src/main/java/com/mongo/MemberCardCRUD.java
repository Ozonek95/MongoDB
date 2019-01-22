package com.mongo;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.List;

public class MemberCardCRUD implements MongoCRUD {

    private MongoCollection collection;
    private MemberCardFactory factory;

    public MemberCardCRUD(MongoCollection collection, MemberCardFactory factory) {
        this.collection = collection;
        this.factory = factory;
    }

    public MemberCardCRUD(MongoCollection collection) {
        this.collection = collection;
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
    public void updateOne(String parameter, Object valueBefore, Object newValue) {
        collection.updateOne(Filters.eq(parameter,valueBefore),Updates.set(parameter,newValue));
    }

    @Override
    public void updateOne(String parameter, Object parameterValue, String newParameter, Object newParameterValue) {
        collection.updateOne(Filters.eq(parameter,parameterValue),Updates.set(newParameter,newParameterValue));
    }

    @Override
    public void updateMany(String parameter, Object valueBefore, Object newValue) {
        collection.updateMany(Filters.eq(parameter,valueBefore),Updates.set(parameter,newValue));
    }

    @Override
    public void updateMany(String parameter, Object parameterValue, String newParameterName, Object newParameterValue) {
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

    public void addToDatabase(MemberCard memberCard){
        Document document = factory.create(new Document
                (memberCard.getPerson().getName(),
                        memberCard.getPerson().getSurname()),
                        memberCard.getBooks(),
                        memberCard.getNumber(),
                        memberCard.getDate());
        collection.insertOne(document);
    }

    public FindIterable showByParameters(List<String> parameters, boolean id){
        if(id) {
            return collection.find().projection(Projections.fields(Projections.include(parameters)));
        }
        else return collection.find().projection(Projections.fields(Projections.include(parameters),Projections.exclude("_id")));
    }

}
