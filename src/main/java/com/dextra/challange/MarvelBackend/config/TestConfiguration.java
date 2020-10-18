package com.dextra.challange.MarvelBackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dextra.challange.MarvelBackend.service.DataMockService;

@Configuration
@Profile("test")
public class TestConfiguration {

	@Autowired
	private DataMockService mock;

	@Bean
	public boolean instantiateDatabase() {
		mock.instantiateTestData();
		return true;
	}

}
