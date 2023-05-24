package com.eample.footprint;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.DocumentContext;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest(
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
class FootprintApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void shouldReturnFootprintWhenDataIsSaved(){
		ResponseEntity<String> response = restTemplate.getForEntity("/footprint/1", String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	void shouldNotReturnACashCardWithAnUnknownId(){
		ResponseEntity<String> response = restTemplate.getForEntity("/footprint/1000", String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		assertThat(response.getBody()).isBlank();
	}

}
