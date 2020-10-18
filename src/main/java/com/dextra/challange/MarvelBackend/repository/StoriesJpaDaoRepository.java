package com.dextra.challange.MarvelBackend.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.dextra.challange.MarvelBackend.domain.entity.Character;
import com.dextra.challange.MarvelBackend.domain.entity.History;
import com.dextra.challange.MarvelBackend.exception.ObjectNotFoundException;

@EnableTransactionManagement
@Repository
public class StoriesJpaDaoRepository extends JdbcDaoSupport {
	
	private static Logger logger = LoggerFactory.getLogger(StoriesJpaDaoRepository.class);

	@PersistenceContext
	private EntityManager em;
	
	@Qualifier("dataSource")
	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	public void initialize() {
		this.setDataSource(this.dataSource);
	}

	public List<History> getStories(Integer characterId) {
		
		Character result = null;
		
		try {		
			
			result = em.createNamedQuery("Comic.Find_Histories", Character.class)
					.setParameter(1, characterId)
					.getSingleResult();
		} catch(NoResultException e ) {
			
			logger.error("CharacterRepository >>> getHistory >>> " + characterId + " NotFound");
			throw new ObjectNotFoundException(
					"Object NotFound Exception! Id: " 
							+ characterId 
							+ ", Type: " 
							+ Character.class.getName());
		}

		return result.getHistories();
	}
}