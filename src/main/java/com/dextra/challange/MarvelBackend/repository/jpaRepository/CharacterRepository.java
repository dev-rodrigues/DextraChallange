package com.dextra.challange.MarvelBackend.repository.jpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dextra.challange.MarvelBackend.domain.entity.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
	
	@Query("FROM Character c")
	Page<Character> search(Pageable pageable);
}