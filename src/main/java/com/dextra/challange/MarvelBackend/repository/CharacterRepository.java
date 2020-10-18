package com.dextra.challange.MarvelBackend.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dextra.challange.MarvelBackend.domain.entity.Character;
import com.dextra.challange.MarvelBackend.domain.entity.Comic;
import com.dextra.challange.MarvelBackend.exception.ObjectNotFoundException;

@EnableTransactionManagement
@Repository
public class CharacterRepository {
	
	private static Logger logger = LoggerFactory.getLogger(CharacterRepository.class);

	@PersistenceContext
	private EntityManager em;

	public List<Comic> getComics(Integer characterId) {
		
		Character result = null;
		
		try {		
			result = em.createNamedQuery("Comic.Find_Comics", Character.class).setParameter(1, characterId).getSingleResult();
		} catch(NoResultException e ) {
			logger.error("CharacterRepository >>> getComics >>> " + characterId + " NotFound");
			throw new ObjectNotFoundException(
					"Object NotFound Exception! Id: " 
							+ characterId 
							+ ", Type: " 
							+ Character.class.getName());
		}

		return result.getComics();
	}

}
