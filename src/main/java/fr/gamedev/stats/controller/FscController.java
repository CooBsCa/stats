package fr.gamedev.stats.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FscController {

		@RequestMapping("/")
	    String hello() {
	        return "Hello World, Spring Boot!";
	    }
}
