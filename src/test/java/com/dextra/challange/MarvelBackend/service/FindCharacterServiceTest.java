package com.dextra.challange.MarvelBackend.service;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.dextra.challange.MarvelBackend.domain.entity.Character;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
	MockitoTestExecutionListener.class
})
public class FindCharacterServiceTest {
	
	private final static Integer PAGE = 0;
	private final static Integer SIZE = 24;
	
	
	@Autowired
	private FindCharacterService service;
	
	@Test
	@Order(1)
	public void theReturnMustBeAPage() {
		Page<Character> result = service.pagedSearch(PAGE, SIZE);
		
		assertTrue(result instanceof Page);
	}
	
}










