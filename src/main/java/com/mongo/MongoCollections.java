package com.mongo;

import com.mongo.connection.MongoClientConnectivity;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;

public class MongoCollections {
    private final MongoClient mongoClient;
    private MongoDatabase database;
    public MongoCollections(MongoClientConnectivity mongoClientConnectivity) {
        mongoClient = mongoClientConnectivity.getMongoClient();
    }

    public MongoCollection<Document> getCollection(String name) {
        MongoDatabase library = getDatabase();
        return library.getCollection(name);
    }

    public  void  createCollection(String name){
        getDatabase().createCollection(name);
    }

    public MongoIterable<String> collections(){
        return getDatabase().listCollectionNames();
    }
//
    private MongoDatabase getDatabase() {
        if(database==null){
            database=mongoClient.getDatabase("library");
        }

        return database;
    }
}
