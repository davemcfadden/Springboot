package com.camel.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author Dave McFadden
 *
 */
@RestController
public class ApplicationController {
	
	    @RequestMapping("/")
	    public String index() {
	        return "Greetings from Spring Boot!";
	    }
}
