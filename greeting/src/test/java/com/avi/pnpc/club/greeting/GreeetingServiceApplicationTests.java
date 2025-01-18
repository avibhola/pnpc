package com.avi.pnpc.club.greeting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class GreeetingServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
