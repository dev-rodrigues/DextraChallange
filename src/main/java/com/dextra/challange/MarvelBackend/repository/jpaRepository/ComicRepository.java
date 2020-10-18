package com.dextra.challange.MarvelBackend.repository.jpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dextra.challange.MarvelBackend.domain.entity.Comic;

@Repository
public interface ComicRepository extends JpaRepository<Comic, Integer> {

}
