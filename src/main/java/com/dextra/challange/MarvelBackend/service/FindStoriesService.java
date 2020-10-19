package com.dextra.challange.MarvelBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dextra.challange.MarvelBackend.domain.entity.History;
import com.dextra.challange.MarvelBackend.repository.StoriesJpaDaoRepository;

@Service
public class FindStoriesService {
	
	@Autowired
	private StoriesJpaDaoRepository storiesJpaDaoRepository;

	public List<History> find(Integer characterId) {
		return storiesJpaDaoRepository.getStories(characterId);
	}
}
