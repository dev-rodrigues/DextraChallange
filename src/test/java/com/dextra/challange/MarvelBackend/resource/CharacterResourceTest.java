package com.dextra.challange.MarvelBackend.resource;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.dextra.challange.MarvelBackend.domain.entity.Character;
import com.dextra.challange.MarvelBackend.domain.entity.Event;
import com.dextra.challange.MarvelBackend.domain.entity.History;
import com.dextra.challange.MarvelBackend.domain.entity.Serie;
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
	public void mustReturn200ForPagedList() {
				
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
	
	@Test
	public void shouldReturn404WhenUrlInvalidatesForPagedList() {
		Page<Character> retorno = new PageImpl<>(new ArrayList<>());
		
		when(this.findService.pagedSearch(0, 24))
			.thenReturn(retorno);
		
		given()
			.contentType(ContentType.JSON)
		.when()
			.get("/v1/public/charactersss")
		.then()
			.statusCode(404);
	}
	
	@Test
	public void mustReturn200WhenSearchingForACharacterById() {
		when(this.findService.findById(1))
			.thenReturn(new Character("String name"
					, "String description"
					, new Date()
					, "String resourceURI"
					, "String thumbnail"));
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/v1/public/characters/{characterId}", 1)
		.then()
			.statusCode(200);
	}
	
	@Test
	public void mustReturn404WhenSearchingForACharacterById() {
		when(this.findService.findById(1))
			.thenReturn(new Character("String name"
					, "String description"
					, new Date()
					, "String resourceURI"
					, "String thumbnail"));
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/v1/public/characters/{characterId}", 1)
		.then()
			.statusCode(200);
	}
	
	@Test
	public void mustReturnAListOfEventsForTheCharacter() {
		List<Event> lista = new ArrayList<>();
		
		
		when(this.findEventsService.find(1))
			.thenReturn(lista);
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/v1/public/characters/{characterId}", 1)
		.then()
			.statusCode(200);
	}
	
	
	@Test
	public void mustReturnAListOfSeriesForTheCharacter() {
		List<Serie> lista = new ArrayList<>();
		
		
		when(this.findSeriesService.find(1))
			.thenReturn(lista);
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/v1/public/characters/{characterId}/series", 1)
		.then()
			.statusCode(200);
	}
	
	@Test
	public void mustReturnAListOfStoriesForTheCharacter() {
		List<History> lista = new ArrayList<>();
		
		when(this.findHistoriesService.find(1))
			.thenReturn(lista);
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/v1/public/characters/{characterId}/stories", 1)
		.then()
			.statusCode(200);
	}
}
