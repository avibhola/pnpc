package com.avi.pnpc.club.welcome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GreetingService {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	DiscoveryClient discoveryClient;

	@Autowired
	RestClient restClient;

	public String callGreet(String greetingUrl, String sessionLabel, String logTraceLabel, String eventcityLabel,
			String visitorsLabel) {
		try {

			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(greetingUrl);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.set("visitors", visitorsLabel);
			httpHeaders.set("eventcity", eventcityLabel);
			httpHeaders.set("Accept", "application/json");
			HttpEntity<HttpHeaders> entity = new HttpEntity<HttpHeaders>(httpHeaders);
			System.out.println(entity.toString());
			ResponseEntity<String> response = restTemplate.exchange(greetingUrl, HttpMethod.POST, null, String.class);
			String message = response.getBody().toString();
			System.out.println(message);
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			return "Error  message";
		}
	}

	public String callGreetDescoveryClient(String greetingUrl, String sessionLabel, String logTraceLabel,
			String eventcityLabel, String visitorsLabel) {
		try {

			ServiceInstance serviceInstance = discoveryClient.getInstances("GREETING").get(0);

			String newURl = serviceInstance.getUri() + "/greeting";
			System.out.println(newURl);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(greetingUrl);
			HttpHeaders httpHeaders = new HttpHeaders();
			httpHeaders.set("visitors", visitorsLabel);
			httpHeaders.set("eventcity", eventcityLabel);
			httpHeaders.set("Accept", "application/json");
			HttpEntity<HttpHeaders> entity = new HttpEntity<HttpHeaders>(httpHeaders);
			System.out.println(entity.toString());
			ResponseEntity<String> response = restTemplate.exchange(newURl, HttpMethod.POST, null, String.class);
			String message = response.getBody().toString();
			System.out.println(message);

			String serviceAResponse = restClient.get().uri(serviceInstance.getUri() + "/greeting").retrieve()
					.body(String.class);

			System.out.println(serviceAResponse);
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			return "Error  message";
		}
	}

}
