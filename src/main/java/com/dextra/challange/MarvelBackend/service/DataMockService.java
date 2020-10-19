package com.dextra.challange.MarvelBackend.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dextra.challange.MarvelBackend.domain.entity.Character;
import com.dextra.challange.MarvelBackend.domain.entity.Comic;
import com.dextra.challange.MarvelBackend.domain.entity.Event;
import com.dextra.challange.MarvelBackend.domain.entity.Story;
import com.dextra.challange.MarvelBackend.domain.entity.Serie;
import com.dextra.challange.MarvelBackend.domain.entity.Url;
import com.dextra.challange.MarvelBackend.repository.jpaRepository.CharacterRepository;
import com.dextra.challange.MarvelBackend.repository.jpaRepository.ComicRepository;
import com.dextra.challange.MarvelBackend.repository.jpaRepository.EventRepository;
import com.dextra.challange.MarvelBackend.repository.jpaRepository.HistoryRepository;
import com.dextra.challange.MarvelBackend.repository.jpaRepository.SerieRepository;
import com.dextra.challange.MarvelBackend.repository.jpaRepository.UrlRepository;

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
		
		// cria URLs
		Url ur1 = new Url("marvel.com");
		Url url2 = new Url("marvel.com");
		Url url3 = new Url("marvel.com");
		Url url4 = new Url("marvel.com");		
		urlRepository.saveAll(Arrays.asList(ur1, url2, url3, url4));
		
		// cria quadrinhos
		Comic comic1 = new Comic("Marvel Spidey", "terrigen-cdn-dev.marvel.com/content/prod/1x/webofsm2020001_cov.jpg");
		Comic comic2 = new Comic("Hulk Dogs of War HC", "https://d1466nnw0ex81e.cloudfront.net/n_iv/600/4937720.jpg");
		Comic comic3 = new Comic("Mighty Thor", "https://d1466nnw0ex81e.cloudfront.net/n_iv/600/4548887.jpg");
		Comic comic4 = new Comic("Amazon Black Panther: Panther's Quest ", "https://m.media-amazon.com/images/I/61kpriLjlBL.jpg");				
		comicRepository.saveAll(Arrays.asList(comic1, comic2, comic3, comic4));
		
		// cria séries
		Serie serie1 = new Serie("SpiderMan", "Spider");		
		serie1 = serieRepository.save(serie1);
		
		Serie serie2 = new Serie("Hulk Dogs of War", "Hulk");		
		serie2 = serieRepository.save(serie2);
		
		Serie serie3 = new Serie("Thor", "Thor");		
		serie3 = serieRepository.save(serie3);
		
		Serie serie4 = new Serie("Black Panther", "Black Panther");		
		serie4 = serieRepository.save(serie4);
		
		Character character1 = new Character("SpiderMan", "Spider", new Date(), "marvel.com", "marvel.com.br");
		character1.addComic(comic1);		
		character1.addSerie(serie1);
		character1.addUrl(ur1);

		Story story = new Story("History of SpiderMan", "marvel.com", Arrays.asList(character1));
		story = historyRepository.save(story);
		
		character1.addStories(story);
		character1 = characterRepository.save(character1);
		character1 = characterRepository.findById(character1.getId()).get();
		
		Event event = new Event("Comic", "https://www.ccxp.com.br/");
		event.setCharacter(character1);
		eventRepository.save(event);
		
	}

}
