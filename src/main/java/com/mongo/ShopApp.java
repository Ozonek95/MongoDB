package com.mongo;

import com.mongo.connection.MongoClientConnectivity;
import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ShopApp {
    public static void main(String[] args) {
        MongoClientConnectivity mongoClientConnectivity = new MongoClientConnectivity();
        mongoClientConnectivity.open();

        MongoCollection<Document> books1 = new MongoCollections(mongoClientConnectivity).getCollection("books");



        mongoClientConnectivity.close();
    }

}
