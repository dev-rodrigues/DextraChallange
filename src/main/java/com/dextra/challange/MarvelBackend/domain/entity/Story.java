package com.dextra.challange.MarvelBackend.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.dextra.challange.MarvelBackend.domain.valuableObject.TypeOfHistory;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Story implements Serializable {
	
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
	
	@ManyToMany(mappedBy = "stories")
	private List<Character> characters = new ArrayList<>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "TYPES")
	private Set<Integer> types = new HashSet<>();
	
	public Story() {
		addType(TypeOfHistory.INTERIOR);
	}
	
	public Story(String name, String resourceURI, List<Character> characters) {
		this.name = name;
		this.resourceURI = resourceURI;
		
		for(Character character : characters) {
			this.characters.add(character);
		}		
	}
	
	private void addType(TypeOfHistory perfil) {
		types.add(perfil.getCod());
	}
	
	public Set<TypeOfHistory> getTypes() {
		return types.stream().map(x -> TypeOfHistory.toEnum(x)).collect(Collectors.toSet());
	}
}
