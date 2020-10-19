package com.dextra.challange.MarvelBackend.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.dextra.challange.MarvelBackend.domain.entity.Serie;
import com.dextra.challange.MarvelBackend.exception.ObjectNotFoundException;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, MockitoTestExecutionListener.class })
public class SerieJpaDaoRepositoryTest {
	
	@Autowired
	private SerieJpaDaoRepository repository;
	
	@Test
	@Order(1)
	public void theReturnMustBeAList() {
		List<Serie> result = repository.getSeries(1);

		assertTrue(result instanceof List);
	}

	@Test
	@Order(2)
	public void theReturnOfListCannotBeNull() {
		List<Serie> result = repository.getSeries(1);
		assertNotNull(result);
	}

	@Test
	@Order(3)
	public void throwNotFoundForIdInexistent() {

		ObjectNotFoundException thrown = 
				assertThrows(ObjectNotFoundException.class, 
						() -> repository.getSeries(Integer.MAX_VALUE),
				"Expected ObjectNotFoundException() to throw");

		assertTrue(thrown.getMessage().contains("NotFound"));
	}
}
