package com.dextra.challange.MarvelBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dextra.challange.MarvelBackend.domain.entity.Event;
import com.dextra.challange.MarvelBackend.repository.EventsJpaDaoRepository;

@Service
public class FindEventsService {
	
	@Autowired
	private EventsJpaDaoRepository eventsJpaDaoRepository;

	public List<Event> find(Integer characterId) {
		return eventsJpaDaoRepository.getEvents(characterId);
	}
}
