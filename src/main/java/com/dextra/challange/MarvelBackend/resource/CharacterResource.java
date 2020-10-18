package com.dextra.challange.MarvelBackend.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dextra.challange.MarvelBackend.domain.entity.Character;
import com.dextra.challange.MarvelBackend.service.FindCharacterService;

@RestController
@RequestMapping(value = "/v1/public/characters")
public class CharacterResource {

	@Autowired
	private FindCharacterService findService;

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<Character>> find(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage) {

		Page<Character> result = findService.pagedSearch(page, linesPerPage);
		return ResponseEntity.ok().body(result);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{characterId}")
	public ResponseEntity<Character> findById(@PathVariable("characterId") Integer characterId) {
		
		Character result = findService.findById(characterId);		
		return ResponseEntity.ok().body(result);
	}
}


