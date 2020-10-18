package com.dextra.challange.MarvelBackend.service;

import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dextra.challange.MarvelBackend.domain.entity.Character;
import com.dextra.challange.MarvelBackend.repository.CharacterRepository;

@Service
public class FindCharacterService {

	@Autowired
	private CharacterRepository characterRepository;

	public Page<Character> pagedSearch(Integer page, Integer size) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.ASC, "name");
		return characterRepository.search(pageRequest);
	}
}
