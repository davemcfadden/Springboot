package com.mongo.boot.service;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mongo.boot.config.MongoConfig;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component("mongoFind")
public class MongoFind {
	
	@Autowired
	MongoConfig config;
	
	
	@Value("${spring.data.mongodb.collection}")
	private String collectionName;
	
	
	public FindIterable<Document> findAll(){
		MongoDatabase db = config.getMongoDb();
		MongoCollection<Document> coll = db.getCollection(collectionName);
		return coll.find();
	}
	
	public FindIterable<Document> findById(String id){
		MongoDatabase db = config.getMongoDb();
		MongoCollection<Document> coll = db.getCollection(collectionName);
		Bson filter = new Document("_id",id);
		return coll.find(filter);
	}
	
	public DistinctIterable<String> findDistinct(String key){
	    MongoDatabase db = config.getMongoDb();
	    MongoCollection<Document> coll = db.getCollection(collectionName);
	    DistinctIterable<String> distinctKeys = coll.distinct(key, String.class);
	    return distinctKeys;
    }

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

}
