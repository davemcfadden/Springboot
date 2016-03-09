package com.mongo.boot.service;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mongo.boot.config.MongoConfig;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
/**
 * 
 * @author Dave McFadden
 *
 */
@Component("mongoUpdate")
public class MongoUpdate {
	
	/**
	 *   	db.sampleset.update({"_id":"01011"},{"city":"london"})
		    db.sampleset.update({"_id":"01011"},{"$set":{"city":"london"}})
		    db.sampleset.update({"city":"HADLEY"},{"$set":{"city":"london"}},{"multi":true})
		    db.sampleset.update({"city":"HADLEY"},{"$set":{"city":"london"}},{"multi":true,"upsert":true})
	 */
	
	@Autowired
	MongoConfig config;
	
	
	@Value("${spring.data.mongodb.collection}")
	private String collectionName;

	public String updateOne(String id) {
		MongoDatabase db =config.getMongoDb();
		MongoCollection<Document> coll = db.getCollection(collectionName);
		coll.updateOne(new Document("_id",id),new Document("city","london").append("age", "old"));

		return coll.find(new Document("_id", id)).toString();
	}

	public String updateSingleElement(String id, String city) {
		MongoDatabase db =config.getMongoDb();
		MongoCollection<Document> coll = db.getCollection(collectionName);
		coll.updateOne(new Document("_id",id),new Document("$set", new Document("city","Belfast")));
		return coll.find(new Document("_id", id)).toString();
	}

	public String updateMultiple(String city) {
		MongoDatabase db =config.getMongoDb();
		MongoCollection<Document> coll = db.getCollection(collectionName);
		coll.updateMany(new Document("city",city),new Document("$set", new Document("city","Belfast")));
		return coll.find(new Document("city", city)).toString();
	}
	
	public String upsert(String id, String city) {
		MongoDatabase db =config.getMongoDb();
		MongoCollection<Document> coll = db.getCollection(collectionName);
		coll.updateOne(new Document("_id",id),new Document("$set", new Document("city","Manchester")),new UpdateOptions().upsert(true));
		return coll.find(new Document("city", city)).toString();
	}


}
