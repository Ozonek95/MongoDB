package com.mongo;

import com.mongo.connection.MongoClientConnectivity;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

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

//        members.insertMany(Arrays.asList(
//                membmerCardFactory.create(
//                        new Document().append("name","Kacper").append("surname","Staszek"),
//                        Arrays.asList("1","2")
//                        ,"124551",
//                        new SimpleDateFormat("dd/MM/yyyy").parse("03/07/2011"))
//                ,
//                membmerCardFactory.create(new Document().append("name","Marcin").append("surname","Staszek"),
//                        Arrays.asList("2","3"),
//                        "32455",
//                        new SimpleDateFormat("dd/MM/yyyy").parse("22/08/2000"))
//                , membmerCardFactory.create(new Document().append("name","Rafał").append("surname","Staszek"),
//                        Arrays.asList("5","6"),
//                        "3242455",
//                        new SimpleDateFormat("dd/MM/yyyy").parse("20/02/2001"),
//                        200)
//                , membmerCardFactory.create(new Document().append("name","Kamil").append("surname","Staszek"),
//                        Arrays.asList("1","4"),
//                        "325455",
//                        new SimpleDateFormat("dd/MM/yyyy").parse("20/8/2011"),true)
//
//
//
//        ));


        for (Document book : books.find(new Document("author","J.R.R Tolkien"))){
            System.out.println(book);
        }




//        for (Document existingBook: books.find()){
//            System.out.println(existingBook);
//        }




        mongoClientConnectivity.close();
    }

}
