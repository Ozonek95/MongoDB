package com.mongo;

import com.google.api.services.translate.Translate;
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
        BookMongoCRUD mongoBooksCRUD = new BookMongoCRUD(books,bookFactory);
//        Document document1 = bookFactory.create("test1", "test1", Arrays.asList("test1", "test1"));
//        Document document2 = bookFactory.create("test1", "test1", Arrays.asList("test1", "test1"));


      //  mongoBooksCRUD.addToDatabase(Arrays.asList(document1,document2));



         //mongoBooksCRUD.addToDatabase(bookFactory.create("TYTUŁ","Autor",Arrays.asList("1","3","4")));
        mongoBooksCRUD.updateOne("title","TYTUŁ","NOWY TYTUL");
        mongoBooksCRUD.updateMany("author","test1","Test2");
        mongoBooksCRUD.updateOne("title","test1","newParameter",Arrays.asList(1,2,3));

//        books.insertMany(Arrays.asList(
//                bookFactory.create("Jeden","Dwa",Arrays.asList("1","2")),
//                bookFactory.create("Dwa","Dwa",Arrays.asList("1","2")),
//                bookFactory.create("Trzy","Dwa",Arrays.asList("1","2")),
//                bookFactory.create("Cztery","Dwa",Arrays.asList("1","2")),
//                bookFactory.create("Pięć","Dwa",Arrays.asList("1","2"))
//                ));

//        Set<String> fakeIds = new HashSet<>();
//        membershipCard.updateMany(Filters.exists("books"),Updates.set("books",Arrays.asList("1","2","3")));

        //adding books
//        for (int i=1;i<5;i++){
//            membershipCard.updateMany(Filters.exists("books"),Updates.addToSet("books",String.valueOf(i)));
//        }

        //finding all used books
//        FindIterable<Document> cards = membershipCard
//                .find()
//                .projection(Projections.fields(Projections.include("books"), Projections.exclude("_id")));
//        //
//        System.out.println("SHOW ALL USED BOOKS:");
//        cards.forEach((Block<? super Document>) s-> System.out.println(s));
//        System.out.println("------------------------");
//        for (Document usedBook : cards) {
//            List<String> ids = (List<String>) usedBook.get("books");
//            fakeIds.addAll(ids);
//        }
//
//        System.out.println("SHOW FAKE IDS");
//        fakeIds.forEach(s -> System.out.println(s));
//        System.out.println("----------------------------");
//
//        Map<String, String> booksId = new HashMap<>();
//
//        FindIterable<Document> documents = books
//                .find()
//                .limit(fakeIds.size())
//                .projection(
//                        Projections.fields(Projections.include("_id"))
//                );
//
//
//        Iterator<String> iterator = fakeIds.iterator();
//        for (Document document : documents) {
//            if(iterator.hasNext()){
//            booksId.put(iterator.next(), document.get("_id").toString());}
//        }
//
//        for (Map.Entry<String, String> ids : booksId.entrySet()) {
//            String fakeId = ids.getKey();
//            String realId = ids.getValue();
//
//            membershipCard.updateMany(
//                    Filters.in("books", fakeId),
//                    Updates.addToSet("books", realId)
//            );
//            membershipCard.updateMany(
//                    Filters.in("books", fakeId),
//                    Updates.pull("books", fakeId)
//            );
//        }
//
//        System.out.println("---------------------");

//        membershipCard.updateOne(
//                Filters.exists("_id"),
//                Updates.addEachToSet("books",Arrays.asList("1","2"))
//        );


//
//        FindIterable<Document> documents1 = membershipCard.find();
//        for (Document d: documents1){
//            System.out.println(d);
//        }
//
//        System.out.println("SHOW USED BOOKS");
//
//        Set<String> usedBooksIds = new HashSet<>();
//
//        for (Document d:cards) {
//            usedBooksIds.addAll((List<String>)d.get("books"));
//        }
//
//        usedBooksIds.forEach(s-> System.out.println(s));
//
//        FindIterable<Document> allBooksId = books.find().projection(Projections.fields(Projections.include("_id")));
//
//        List<String> allBooksIds = new ArrayList<>();
//
//        for (Document d:allBooksId) {
//            allBooksIds.add((d.get("_id").toString()));
//        }
//
//        System.out.println("SHOW ALL BOOKS IDS");
//        allBooksIds.forEach(s-> System.out.println(s));
//
////        for (String s:allBooksIds) {
////            if(!usedBooksIds.contains(s)){
////                books.deleteOne(Filters.eq("_id",s));
////            }
////        }
//        List<ObjectId> ids = new ArrayList<>();
//        for (String s:usedBooksIds) {
//            ids.add(new ObjectId(s));
//        }
//
//       books.deleteMany(Filters.nin("_id",ids));
//
//        System.out.println("DONE");
//        mongoClientConnectivity.close();
    }

}
