package com.dextra.challange.MarvelBackend.service;

import org.springframework.data.domain.Sort;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dextra.challange.MarvelBackend.domain.entity.Character;
import com.dextra.challange.MarvelBackend.exception.ObjectNotFoundException;
import com.dextra.challange.MarvelBackend.repository.jpaRepository.CharacterRepository;

@Service
public class FindCharacterService {

	@Autowired
	private CharacterRepository characterRepository;

	
	/**
	 * Method to list Characters
	 * 
	 * @author Carlos Henrique
	 * @since 18/10/2020
	 * 
	 * @param page - total pages
	 * @param linesPerPage - lines per page
	 * 
	 * @return 
	 * Page<Character>	
	 */
	public Page<Character> pagedSearch(Integer page, Integer size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");
		return characterRepository.search(pageRequest);
	}
	
	public Character findById(Integer characterId) {
		Optional<Character> localizedObject = characterRepository.findById(characterId);
		
		return localizedObject.orElseThrow(
				() -> new ObjectNotFoundException(
						"Object NotFound Exception! Id: " 
								+ characterId 
								+ ", Type: " 
								+ Character.class.getName()));
	}
}
