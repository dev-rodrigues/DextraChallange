package com.dextra.challange.MarvelBackend.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Comic implements Serializable {

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

	@ManyToMany(mappedBy = "comics")
	private List<Character> characters = new ArrayList<>();

	public Comic() {

	}

	public Comic(String name, String resourceURI) {
		this.name = name;
		this.resourceURI = resourceURI;
	}
}