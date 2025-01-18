package com.avi.pnpc.club.welcome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avi.pnpc.club.welcome.service.GreetingService;

@RestController
public class WelcomeController {

	@Value("${pnpc.greet.message.welcomemessage}")
	private String greeting;
	
	@Value("${pnpc.club.welcome.greeting.url}")
	private String greetingUrl;
	
	@Autowired
	GreetingService greetingService;

	@GetMapping("/welcome")
	public String welcomeGreet() {
		return greeting;
	}

	@GetMapping("/welcome2")
	public String welcomeGreet1(@RequestParam("session") String sessionLabel,
			@RequestHeader(value = "logTrace", required = true) String logTraceLabel,
			@RequestParam("eventcity") String eventcityLabel, @RequestHeader("visitors") String visitorsLabel) {
		
		String greetingMessage=greetingService.callGreet(greetingUrl,sessionLabel,logTraceLabel,eventcityLabel,visitorsLabel);
		return greetingMessage;
	}
	
	@GetMapping("/welcome3")
	public String welcomeGreet3(@RequestParam("session") String sessionLabel,
			@RequestHeader(value = "logTrace", required = true) String logTraceLabel,
			@RequestParam("eventcity") String eventcityLabel, @RequestHeader("visitors") String visitorsLabel) {
		
		String greetingMessage=greetingService.callGreetDescoveryClient(greetingUrl,sessionLabel,logTraceLabel,eventcityLabel,visitorsLabel);
		return greetingMessage;
	}

}
