package com.mongo;

import com.mongo.connection.MongoClientConnectivity;

public class ShopApp {
    public static void main(String[] args) {
        MongoClientConnectivity mongoClientConnectivity = new MongoClientConnectivity();
        mongoClientConnectivity.open();


        mongoClientConnectivity.close();
    }

}
