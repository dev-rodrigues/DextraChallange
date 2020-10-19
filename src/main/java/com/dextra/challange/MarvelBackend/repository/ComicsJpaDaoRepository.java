package com.dextra.challange.MarvelBackend.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.dextra.challange.MarvelBackend.domain.entity.Character;
import com.dextra.challange.MarvelBackend.domain.entity.Comic;
import com.dextra.challange.MarvelBackend.exception.ObjectNotFoundException;

@EnableTransactionManagement
@Repository
public class ComicsJpaDaoRepository extends JdbcDaoSupport {
	
	private static Logger logger = LoggerFactory.getLogger(ComicsJpaDaoRepository.class);

	@PersistenceContext
	private EntityManager em;
	
	@Qualifier("dataSource")
	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	public void initialize() {
		this.setDataSource(this.dataSource);
	}

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
