package com.avi.pnpc.club.greeting.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Value("${pnpc.greet.message.greetmessage}")
	private String greetingContent;

	@GetMapping("/greeting")
	public ResponseEntity<String> greet(@RequestHeader("eventcity") String eventLocation,
			@RequestHeader("visitors") String visitorsName) {
		try {
			String greetmsg ="Hello "+visitorsName + greetingContent + " " +eventLocation;
			return new ResponseEntity<>(greetmsg, HttpStatus.OK);
		} catch (Exception e) {
			String greetmsg = "Server error";
			return new ResponseEntity<>(greetmsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@PostMapping("/greeting")
	public ResponseEntity<String> greetpost(@RequestHeader(value = "eventcity", required=false) String eventLocation,
			@RequestHeader(value = "visitors", required=false) String visitorsName) {
		try {
			String greetmsg ="Hello "+visitorsName + greetingContent + " " +eventLocation;
			return new ResponseEntity<>(greetmsg, HttpStatus.OK);
		} catch (Exception e) {
			String greetmsg = "Server error";
			return new ResponseEntity<>(greetmsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
