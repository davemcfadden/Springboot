package com.mongo.boot.controller;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.boot.service.MongoFind;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
/**
 * 
 * @author Dave McFadden
 *
 */
@RestController
@RequestMapping(value = "/find")
public class FindController {
	
	
		@Autowired
		MongoFind mongoFind;
	
	    @RequestMapping("/all")
	    public String findAll() {
	    	List<String> list = new ArrayList<String>();
			for(Document res : mongoFind.findAll()){
				list.add(res.toJson());
			}
			return list.toString();
	    }
	    
	    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	    public String findByPrimaryKey(@PathVariable  String id) {
	    	List<String> list = new ArrayList<String>();
			for(Document res : mongoFind.findById(id)){
				list.add(res.toJson());
			}
			return list.toString();
	    }
	    
	    @RequestMapping(value = "/id/greater/{id}", method = RequestMethod.GET)
	    public String findByIdGreaterThan(@PathVariable  String id) {
	    	List<String> list = new ArrayList<String>();
			for(Document res : mongoFind.findByIdGreaterThan(id)){
				list.add(res.toJson());
			}
			return list.toString();
	    }
	    
	    
	    
	    //TODO change method to receive a json body with a number of ids
	    @RequestMapping(value = "/firstid/{idOne}/secondid/{idTwo}", method = RequestMethod.GET)
	    public String findIdIn(@PathVariable  String idOne,@PathVariable  String idTwo) {
	    	List<Integer> requestIds = new ArrayList<Integer>();
	    	requestIds.add(Integer.parseInt(idOne));
	    	requestIds.add(Integer.parseInt(idTwo));
	    	List<String> list = new ArrayList<String>();
			for(Document res : mongoFind.findIdIn(requestIds)){
				list.add(res.toJson());
			}
			return list.toString();
	    }
	    
	    
	    @RequestMapping(value = "/id/{id}/city/{city}", method = RequestMethod.GET)
	    public String findByIdAndCity(@PathVariable  String id,@PathVariable  String city) {
	    	List<String> list = new ArrayList<String>();
			for(Document res : mongoFind.findByIdAndCity(id,city)){
				list.add(res.toJson());
			}
			return list.toString();
	    }
	    
	    
	    @RequestMapping(value = "/id/{id}/projection", method = RequestMethod.GET)
	    public String findByIdChangeResult(@PathVariable  String id) {
	    	List<String> list = new ArrayList<String>();
			for(Document res : mongoFind.findById(id)){
				list.add(res.toJson());
			}
			return list.toString();
	    }
	    
	    
	    @RequestMapping(value = "/distinct/{key}", method = RequestMethod.GET)
	    public String findDistinctByKey(@PathVariable  String key) {
	        List<String> list = new ArrayList<String>();
	        for(String res : mongoFind.findDistinct(key)){
	          list.add(res);
	        }
	        return list.toString();
	    }
	    
	    @RequestMapping(value = "/findone", method = RequestMethod.GET)
	    public String findOne() {
	        return mongoFind.findOne();
	    }
	    
	    @RequestMapping(value = "/findone/{id}", method = RequestMethod.GET)
	    public String findOne(@PathVariable  String id) {
	    	 return mongoFind.findOne(id);
	    }
	    
	    
	    
	    
}
