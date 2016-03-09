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
@Component("mongoInsert")
public class MongoInsert {
	
	
	@Autowired
	MongoConfig config;
	
	
	@Value("${spring.data.mongodb.collection}")
	private String collectionName;
	

	public long persistMessage(String json) {
		MongoDatabase db = config.getMongoDb();
		MongoCollection<Document> coll = db.getCollection(collectionName);
		Document doc = Document.parse(json);
		coll.insertOne(doc);
		
		//confirm entry
		return coll.count(new Document("_id", doc.get("_id")));
	}

}
