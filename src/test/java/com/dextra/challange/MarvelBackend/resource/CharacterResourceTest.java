package com.dextra.challange.MarvelBackend.resource;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.dextra.challange.MarvelBackend.domain.entity.Character;
import com.dextra.challange.MarvelBackend.service.FindCharacterService;
import com.dextra.challange.MarvelBackend.service.FindComicBookCharacterService;
import com.dextra.challange.MarvelBackend.service.FindEventsService;
import com.dextra.challange.MarvelBackend.service.FindSeriesService;
import com.dextra.challange.MarvelBackend.service.FindStoriesService;

import io.restassured.http.ContentType;

@WebMvcTest
public class CharacterResourceTest {
	
	@Autowired
	private CharacterResource resource;
	
	@MockBean
	private FindCharacterService findService;
	
	@MockBean
	private FindComicBookCharacterService findComicBookCharacterService;
	
	@MockBean
	private FindEventsService findEventsService;
	
	@MockBean
	private FindSeriesService findSeriesService;
	
	@MockBean
	private FindStoriesService findHistoriesService;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.resource);
	}
	
	@Test
	public void shouldReturnAPaginatedList() {
				
		Page<Character> retorno = new PageImpl<>(new ArrayList<>());
				
		when(this.findService.pagedSearch(0, 24))
			.thenReturn(retorno);
		
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("/v1/public/characters")
		.then()
			.statusCode(200);		
	}
	
}
