package com.mongo.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

@Component("mongoConfig")
public class MongoConfig {
	
	MongoDatabase mongoDb;
	
	
	
	@Autowired
    public MongoConfig(MongoClient mongoClient, @Value("${spring.data.mongodb.database}") String databaseName) {
        this.mongoDb = mongoClient.getDatabase(databaseName);
    }

	public MongoDatabase getMongoDb() {
		return mongoDb;
	}

	public void setMongoDb(MongoDatabase mongoDb) {
		this.mongoDb = mongoDb;
	}

}
