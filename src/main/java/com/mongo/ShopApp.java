package com.mongo;

import com.mongo.connection.MongoClientConnectivity;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class ShopApp {
    public static void main(String[] args) throws ParseException {
        MongoClientConnectivity mongoClientConnectivity = new MongoClientConnectivity();
        mongoClientConnectivity.open();

        MongoCollection<Document> books = new MongoCollections(mongoClientConnectivity).getCollection("books");

        MongoCollection<Document> members = new MongoCollections(mongoClientConnectivity).getCollection("members");

        MemberCardFactory membmerCardFactory = new MemberCardFactory();

//        members.insertOne(membmerCardFactory.create(new Document().append("name","Kamil").append("surname","Staszek"),
//                        Arrays.asList("1","4"),
//                        "325455",
//                        new SimpleDateFormat("dd/MM/yyyy").parse("20/8/2011"),300));

        Bson membersWithPenalties = Filters.exists("penalty");
        Bson documentsWithPenalty = Filters.gt("penalty",200);

        FindIterable<Document> documents = members.find(documentsWithPenalty).projection(Projections.fields(Projections.exclude("_id")));
       for (Document d: documents){
           System.out.println(d);
       }
       for (Document d: members.find(membersWithPenalties)){
           System.out.println(d);

        for (Document book : books.find(new Document("author","J.R.R Tolkien"))){
            System.out.println(book);
        }



        mongoClientConnectivity.close();
    }

}
