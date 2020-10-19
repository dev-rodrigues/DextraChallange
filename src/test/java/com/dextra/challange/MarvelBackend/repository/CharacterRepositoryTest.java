package com.dextra.challange.MarvelBackend.repository;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.dextra.challange.MarvelBackend.domain.entity.Character;
import com.dextra.challange.MarvelBackend.repository.jpaRepository.CharacterRepository;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@TestExecutionListeners({ 
		DependencyInjectionTestExecutionListener.class
	, 	MockitoTestExecutionListener.class 
	})
public class CharacterRepositoryTest {
	
	private final static Integer PAGE = 0;
	private final static Integer SIZE = 24;

	@Autowired
	private CharacterRepository repository;
	
	@Test
	@Order(1)
	public void shouldFetchAPagedList() {
		
		PageRequest pageRequest = PageRequest.of(PAGE, SIZE, Sort.Direction.ASC, "name");
		Page<Character> result = repository.search(pageRequest);
		
		assertTrue(result instanceof Page);
	}
	
	public void shouldNotReturnANullList() {
		PageRequest pageRequest = PageRequest.of(PAGE, SIZE, Sort.Direction.ASC, "name");
		Page<Character> result = repository.search(pageRequest);
		
		assertNotNull(result);
	}
}
