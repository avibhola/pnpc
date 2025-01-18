package com.avi.pnpc.club.welcome.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomeConfig {

    @Bean
    RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
    
    
    @Bean
    RestClient getRestClient() {
    	RestClient restClient = RestClient.builder().build();
		return restClient;
	}

}

