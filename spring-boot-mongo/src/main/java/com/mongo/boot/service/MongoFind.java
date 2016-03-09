package com.mongo.boot.service;

import java.util.List;

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
/**
 * 
 * @author Dave McFadden
 *
 */

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
	
	public FindIterable<Document> findByIdGreaterThan(String id){
		MongoDatabase db = config.getMongoDb();
		MongoCollection<Document> coll = db.getCollection(collectionName);
		Bson filter = new Document("_id", new Document("$gt",id));
		return coll.find(filter);
	}
	
    //db.sampleset.find({"_id":{"$in":["01035","01033"})
	public FindIterable<Document> findIdIn(List<String> ids){
		MongoDatabase db = config.getMongoDb();
		MongoCollection<Document> coll = db.getCollection(collectionName);
		Bson filter = new Document("_id", new Document("$in",ids));
		return coll.find(filter);
	}
	
	
	//db.sampleset.find({"_id":"01035","city":"HADLEY"})
	public FindIterable<Document> findByIdAndCity(String id, String city){
		MongoDatabase db = config.getMongoDb();
		MongoCollection<Document> coll = db.getCollection(collectionName);
		Bson filter = new Document("_id", id)
						.append("city", city);
		return coll.find(filter);
	}
	
	//db.sampleset.find({"_id":"01011"},{"_id":false},"city":true)
	public FindIterable<Document> findByIdChangeResult(String id){
		MongoDatabase db = config.getMongoDb();
		MongoCollection<Document> coll = db.getCollection(collectionName);
		Bson projection = new Document("_id",0).append("city", 1);
		Bson filter = new Document("_id", id);
		return coll.find(filter).projection(projection);
	}
	
	
	public DistinctIterable<String> findDistinct(String key){
	    MongoDatabase db = config.getMongoDb();
	    MongoCollection<Document> coll = db.getCollection(collectionName);
	    DistinctIterable<String> distinctKeys = coll.distinct(key, String.class);
	    return distinctKeys;
    }

	public String findOne(String id){
	    MongoDatabase db = config.getMongoDb();
	    MongoCollection<Document> coll = db.getCollection(collectionName);
	    Bson filter = new Document("_id",id);
	    return coll.find(filter).first().toString();
    }
	
	public String findOne(){
	    MongoDatabase db = config.getMongoDb();
	    MongoCollection<Document> coll = db.getCollection(collectionName);
	    return coll.find().first().toString();
    }
	
	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

}
