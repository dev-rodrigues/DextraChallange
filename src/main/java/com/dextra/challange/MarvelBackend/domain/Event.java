package com.dextra.challange.MarvelBackend.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Integer id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String resourceURI;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="character_id")
	private Character character;

	public Event() {

	}

	public Event(String name, String resourceURI) {
		this.name = name;
		this.resourceURI = resourceURI;
	}
}
