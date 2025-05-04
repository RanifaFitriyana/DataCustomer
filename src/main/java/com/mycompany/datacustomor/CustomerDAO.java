/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.datacustomor;

import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ACER
 */
public class CustomerDAO {
    private final MongoCollection<Document> collection;

    public CustomerDAO() {
        collection = MongoConnection.getCustomerCollection();
    }

    public void addCustomer(DataCustomor customer) {
        Document doc = new Document("name", customer.getName())
                            .append("email", customer.getEmail());
        collection.insertOne(doc);
    }

    public List<DataCustomor> getAllCustomers() {
        List<DataCustomor> list = new ArrayList<>();
        FindIterable<Document> docs = collection.find();
        for (Document doc : docs) {
            String id = doc.getObjectId("_id").toHexString();
            String name = doc.getString("name");
            String email = doc.getString("email");
            list.add(new DataCustomor(id, name, email));
        }
        return list;
    }

    public void deleteCustomer(String id) {
        collection.deleteOne(new Document("_id", new ObjectId(id)));
    }

    public void updateCustomer(DataCustomor customer) {
        Document query = new Document("_id", new ObjectId(customer.getId()));
        Document newData = new Document("$set", new Document("name", customer.getName())
                                                     .append("email", customer.getEmail()));
        collection.updateOne(query, newData);
    }
}
