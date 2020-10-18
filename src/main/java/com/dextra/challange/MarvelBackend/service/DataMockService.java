package com.dextra.challange.MarvelBackend.service;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.dextra.challange.MarvelBackend.domain.entity.Character;
import com.dextra.challange.MarvelBackend.repository.CharacterRepository;

@Service
public class DataMockService {

	@Autowired
	private CharacterRepository characterRepository;

	public void instantiateTestData() {
		Character character1 = new Character("Spider Man", "Spider", new Date(), "", "");
		Character character2 = new Character("Spider Man", "Spider", new Date(), "", "");
		Character character3 = new Character("Spider Man", "Spider", new Date(), "", "");
		Character character4 = new Character("Spider Man", "Spider", new Date(), "", "");
		Character character5 = new Character("Spider Man", "Spider", new Date(), "", "");

		characterRepository.saveAll(Arrays.asList(character1, character2, character3, character4, character5));
	}

}
