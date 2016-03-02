package com.mongo.boot.service;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongo.boot.config.MongoConfig;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component("mongoFind")
public class MongoFind {
	
	@Autowired
	MongoConfig config;
	
	
	public FindIterable<Document> findAll(){
		MongoDatabase db = config.getMongoDb();
		MongoCollection<Document> coll = db.getCollection("sampleset");
		return coll.find();
	}
	
	public FindIterable<Document> findById(String id){
		MongoDatabase db = config.getMongoDb();
		MongoCollection<Document> coll = db.getCollection("sampleset");
		Bson filter = new Document("_id",id);
		return coll.find(filter);
	}
	

}