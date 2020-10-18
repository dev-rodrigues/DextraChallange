package com.dextra.challange.MarvelBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dextra.challange.MarvelBackend.domain.entity.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Integer> {

}
