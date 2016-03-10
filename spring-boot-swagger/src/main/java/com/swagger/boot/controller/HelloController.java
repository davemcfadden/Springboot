package com.swagger.boot.controller;

import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author Dave McFadden
 *
 */
@RestController
public class HelloController {
	
	    @RequestMapping(value = "/", method = RequestMethod.GET)
	    @ApiOperation(value = "Get Hello controller response")
	    public String hello() {
	       return "Hello Controller";
	    }
	    
	    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
	    @ApiOperation(value = "Simple API that will take a single name pamam and return a string reponse")
	    public String helloName(@PathVariable String name) {
	       return "Hello " + name;
	    }
	    
}
	    
