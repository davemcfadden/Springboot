package com.mongo.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

@Service("mongoConfig")
public class MongoConfig {
	
	MongoDatabase mongoDb;
	
	@Autowired
    public MongoConfig(MongoClient mongoClient) {
        this.mongoDb = mongoClient.getDatabase("sampleset");
    }

	public MongoDatabase getMongoDb() {
		return mongoDb;
	}

	public void setMongoDb(MongoDatabase mongoDb) {
		this.mongoDb = mongoDb;
	}
	
	
	

}
