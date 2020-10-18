package com.dextra.challange.MarvelBackend.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dextra.challange.MarvelBackend.domain.entity.Character;
import com.dextra.challange.MarvelBackend.domain.entity.Comic;
import com.dextra.challange.MarvelBackend.service.FindCharacterService;
import com.dextra.challange.MarvelBackend.service.FindComicBookCharacterService;

@RestController
@RequestMapping(value = "/v1/public/characters")
public class CharacterResource {

	@Autowired
	private FindCharacterService findService;
	
	@Autowired
	private FindComicBookCharacterService findComicBookCharacterService;

	
	/**
	 * Método que lista personagens
	 * 
	 * @author Carlos Henrique
	 * @since 18/10/2020
	 * 
	 * @param page - total pages
	 * @param linesPerPage - lines per page
	 * 
	 * @return ResponseEntity with a Page<Character> object and the HTTP status
	 * 
	 * HTTP Status:
	 * 
	 * 200 - OK
	 * 400 - Bad Request
	 * 404 - Not Found
	 * 500 - Server Errors
	 * 
	 * @throws ObjectNotFoundException
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<Character>> find(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage) {

		Page<Character> result = findService.pagedSearch(page, linesPerPage);
		return ResponseEntity.ok().body(result);
	}
	
	
	/**
	 * Method that searches for a Character given the id
	 * 
	 * @author Carlos Henrique
	 * @since 18/10/2020
	 * 
	 * @param characterId - Desired Character Id
	 * 
	 * @return ResponseEntity with a Character object and the HTTP status
	 * 
	 * HTTP Status:
	 * 
	 * 200 - OK
	 * 400 - Bad Request
	 * 404 - Not Found
	 * 500 - Server Errors
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{characterId}")
	public ResponseEntity<Character> findById(@PathVariable("characterId") Integer characterId) {
		
		Character result = findService.findById(characterId);		
		return ResponseEntity.ok().body(result);
	}
		
	@RequestMapping(method = RequestMethod.GET, value = "/{characterId}/comics")
	public ResponseEntity<List<Comic>> findComic(@PathVariable("characterId") Integer characterId) {
		
		List<Comic> result = findComicBookCharacterService.find(characterId);		
		return ResponseEntity.ok().body(result);
	}
}


