/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datacustomor;

import com.mongodb.client.*;
import org.bson.Document;
/**
 *
 * @author ACER
 */
public class MongoConnection {
    private static final String URI = "mongodb://localhost:27017";
    private static final String DB_NAME = "CustomerDB";

    public static MongoDatabase getDatabase() {
        MongoClient mongoClient = MongoClients.create(URI);
        return mongoClient.getDatabase(DB_NAME);
    }

    public static MongoCollection<Document> getCustomerCollection() {
        return getDatabase().getCollection("customers");
    }
}
