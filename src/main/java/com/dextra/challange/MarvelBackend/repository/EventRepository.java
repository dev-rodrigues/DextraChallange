package com.dextra.challange.MarvelBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dextra.challange.MarvelBackend.domain.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

}
