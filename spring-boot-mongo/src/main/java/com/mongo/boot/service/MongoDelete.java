package com.mongo.boot.service;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mongo.boot.config.MongoConfig;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
/**
 * 
 * @author Dave McFadden
 *
 */
@Component("mongoDelete")
public class MongoDelete {
	
	@Autowired
	MongoConfig config;
	
	
	@Value("${spring.data.mongodb.collection}")
	private String collectionName;
	
	
	public void delete(String id){
		MongoDatabase db = config.getMongoDb();
		MongoCollection<Document> coll = db.getCollection(collectionName);
		coll.deleteOne(new Document("_id",id));
	}
	
	
	public void deleteAll(){
		MongoDatabase db = config.getMongoDb();
		MongoCollection<Document> coll = db.getCollection(collectionName);
		coll.deleteMany(new Document());
	}
	
	

}
