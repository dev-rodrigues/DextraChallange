package com.dextra.challange.MarvelBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dextra.challange.MarvelBackend.domain.entity.Comic;
import com.dextra.challange.MarvelBackend.repository.ComicJpaDaoRepository;

@Service
public class FindComicBookCharacterService {
	
	@Autowired
	private ComicJpaDaoRepository comicRepository;

	public List<Comic> find(Integer characterId) {
		return comicRepository.getComics(characterId);
	}
}
