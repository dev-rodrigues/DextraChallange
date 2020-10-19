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

//
		Url url1 = new Url("marvel.com");
		Url url2 = new Url("marvel.com");
		Url url3 = new Url("marvel.com");
		Url url4 = new Url("marvel.com");
		urlRepository.saveAll(Arrays.asList(url1, url2, url3, url4));

//
		Comic comic1 = new Comic("Marvel Spidey", "terrigen-cdn-dev.marvel.com/content/prod/1x/webofsm2020001_cov.jpg");
		Comic comic2 = new Comic("Hulk Dogs of War HC", "https://d1466nnw0ex81e.cloudfront.net/n_iv/600/4937720.jpg");
		Comic comic3 = new Comic("Mighty Thor", "https://d1466nnw0ex81e.cloudfront.net/n_iv/600/4548887.jpg");
		Comic comic4 = new Comic("Amazon Black Panther: Panther's Quest ",
				"https://m.media-amazon.com/images/I/61kpriLjlBL.jpg");
		comicRepository.saveAll(Arrays.asList(comic1, comic2, comic3, comic4));

//
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
		character1.addUrl(url1);

		Character character2 = new Character("Hulk", "Hulk", new Date(), "marvel.com", "marvel.com.br");
		character2.addComic(comic2);
		character2.addSerie(serie2);
		character2.addUrl(url2);

		Character character3 = new Character("Thor", "Thor", new Date(), "marvel.com", "marvel.com.br");
		character3.addComic(comic3);
		character3.addSerie(serie3);
		character3.addUrl(url3);

		Character character4 = new Character("Black Panther", "Black Panther", new Date(), "marvel.com",
				"marvel.com.br");
		character4.addComic(comic4);
		character4.addSerie(serie4);
		character4.addUrl(url4);
///
		Story story1 = new Story("History of SpiderMan", "marvel.com", Arrays.asList(character1));
		story1 = historyRepository.save(story1);

		character1.addStories(story1);
		character1 = characterRepository.save(character1);
		character1 = characterRepository.findById(character1.getId()).get();

		Event event = new Event("Comic", "https://www.ccxp.com.br/");
		event.setCharacter(character1);
		eventRepository.save(event);

//
		Story story2 = new Story("History of SpiderMan", "marvel.com", Arrays.asList(character2));
		story2 = historyRepository.save(story2);

		character2.addStories(story2);
		character2 = characterRepository.save(character2);
		character2 = characterRepository.findById(character2.getId()).get();

		Event event2 = new Event("Comic", "https://www.ccxp.com.br/");
		event2.setCharacter(character2);
		eventRepository.save(event2);

//
		Story story3 = new Story("History of SpiderMan", "marvel.com", Arrays.asList(character3));
		story3 = historyRepository.save(story3);

		character3.addStories(story3);
		character3 = characterRepository.save(character3);
		character3 = characterRepository.findById(character3.getId()).get();

		Event event3 = new Event("Comic", "https://www.ccxp.com.br/");
		event3.setCharacter(character3);
		eventRepository.save(event3);
		
		
//
		Story story4 = new Story("History of SpiderMan", "marvel.com", Arrays.asList(character4));
		story4 = historyRepository.save(story4);

		character4.addStories(story3);
		character4 = characterRepository.save(character4);
		character4 = characterRepository.findById(character4.getId()).get();

		Event event4 = new Event("Comic", "https://www.ccxp.com.br/");
		event4.setCharacter(character4);
		eventRepository.save(event4);

	}

}
