package com.lin.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class BeansInitializer {

	@Bean
	public ObjectMapper initializeObjectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public ModelMapper initializeModelMapper() {
		return new ModelMapper();
	}
}
