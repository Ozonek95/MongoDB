package com.mongo;

import com.mongo.connection.MongoClientConnectivity;
import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.*;

public class ShopApp {

    public static void main( String[] args ) {
        MongoClientConnectivity mongoClientConnectivity = new MongoClientConnectivity();
        mongoClientConnectivity.open();

        MongoCollections collections = new MongoCollections(mongoClientConnectivity);

        MongoCollection<Document> membershipCard = collections.getCollection("members");
        MongoCollection<Document> books = collections.getCollection("books");

        BookFactory bookFactory = new BookFactory();
        MongoCRUD mongoBooksCRUD = new BookMongoCRUD(books,bookFactory);

        MemberCardFactory memberCardFactory = new MemberCardFactory();
        MongoCRUD mongoMembersCardCRUD = new MemberCardCRUD(membershipCard,memberCardFactory);

        Document document1 = bookFactory.create("test1", "test1", Arrays.asList("test1", "test1"));
        Document document2 = bookFactory.create("test1", "test1", Arrays.asList("test1", "test1"));

        MemberCard memberCard = new MemberCard(new Person("Kacpi","Staszek"),Arrays.asList("Tytuł1","tytuł2"),"Number",new Date());

        String parameterToShow = "title";
        FindIterable<Document> titles = mongoBooksCRUD.showByParameters(Arrays.asList(parameterToShow), false);
        for (Document d:titles) {
            System.out.println(d.get(parameterToShow).toString());
        }

        ((MemberCardCRUD) mongoMembersCardCRUD).addToDatabase(memberCard);

        mongoBooksCRUD.addToDatabase(Arrays.asList(document1,document2));




        mongoBooksCRUD.addToDatabase(bookFactory.create("TYTUŁ","Autor",Arrays.asList("1","3","4")));
        mongoBooksCRUD.updateOne("title","TYTUŁ","NOWY TYTUL");
        mongoBooksCRUD.updateMany("author","test1","Test2");
        mongoBooksCRUD.updateOne("title","test1","newParameter",Arrays.asList(1,2,3));


        mongoClientConnectivity.close();
    }

}
