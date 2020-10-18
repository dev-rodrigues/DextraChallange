package com.dextra.challange.MarvelBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dextra.challange.MarvelBackend.domain.entity.Serie;
import com.dextra.challange.MarvelBackend.repository.SerieJpaDaoRepository;

@Service
public class FindSeriesService {
	
	@Autowired
	private SerieJpaDaoRepository serieJpaDaoRepository;

	public List<Serie> find(Integer characterId) {
		return serieJpaDaoRepository.getSeries(characterId);
	}
}
