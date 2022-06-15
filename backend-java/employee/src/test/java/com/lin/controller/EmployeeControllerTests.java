package com.lin.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lin.app.EmployeeApplication;
import com.lin.dto.ApiResult;

@SpringBootTest(classes = EmployeeApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testGetEmployeeById() throws Exception {
		String result = objectMapper.writeValueAsString(ApiResult.fail());
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/employee" + "/1", String.class))
				.contains(result);
	}
}
