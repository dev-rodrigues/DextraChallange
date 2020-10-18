package com.dextra.challange.MarvelBackend.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dextra.challange.MarvelBackend.domain.entity.Character;
import com.dextra.challange.MarvelBackend.domain.entity.Comic;
import com.dextra.challange.MarvelBackend.domain.entity.Event;
import com.dextra.challange.MarvelBackend.domain.entity.History;
import com.dextra.challange.MarvelBackend.domain.entity.Serie;
import com.dextra.challange.MarvelBackend.domain.entity.Url;
import com.dextra.challange.MarvelBackend.repository.CharacterRepository;
import com.dextra.challange.MarvelBackend.repository.ComicRepository;
import com.dextra.challange.MarvelBackend.repository.EventRepository;
import com.dextra.challange.MarvelBackend.repository.HistoryRepository;
import com.dextra.challange.MarvelBackend.repository.SerieRepository;
import com.dextra.challange.MarvelBackend.repository.UrlRepository;

@Service
public class DataMockService {

	@Autowired
	private CharacterRepository characterRepository;
	
	@Autowired
	private UrlRepository urlRepository;
	
	@Autowired
	private ComicRepository comicRepository;
	
	@Autowired
	private SerieRepository serieRepository;
	
	@Autowired
	private HistoryRepository historyRepository;
	
	@Autowired
	private EventRepository eventRepository;

	public void instantiateTestData() {
		Url ur1 = new Url("g1.com.br");		
		urlRepository.saveAll(Arrays.asList(ur1));
		
		Comic comic1 = new Comic("Marvel Spidey Will Get His Science", "terrigen-cdn-dev.marvel.com/content/prod/1x/webofsm2020001_cov.jpg");
		comicRepository.saveAll(Arrays.asList(comic1));
		
		Serie serie = new Serie("SpiderMan", "Spider");
		serie = serieRepository.save(serie);
		
		Character character1 = new Character("SpiderMan", "Spider", new Date(), "marvel.com", "marvel.com.br");
		character1.addComic(comic1);		
		character1.addSerie(serie);
		character1.addUrl(ur1);

		character1 = characterRepository.save(character1);
		character1 = characterRepository.findById(character1.getId()).get();
				
		History history = new History("History of SpiderMan", "marvel.com", Arrays.asList(character1));
		historyRepository.saveAll(Arrays.asList(history));
	}

}
