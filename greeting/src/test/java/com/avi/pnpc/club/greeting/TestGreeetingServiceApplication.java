package com.avi.pnpc.club.greeting;

import org.springframework.boot.SpringApplication;

public class TestGreeetingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(GreeetingServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
