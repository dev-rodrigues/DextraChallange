package com.dextra.challange.MarvelBackend.dto;

import java.io.Serializable;
import java.util.Date;

import com.dextra.challange.MarvelBackend.domain.entity.Character;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

public class CharacterDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Integer id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String description;

	@Getter
	@Setter
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date modified;

	@Getter
	@Setter
	private String resourceURI;

	public CharacterDTO() {

	}

	public CharacterDTO(Character obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.description = obj.getDescription();
		this.modified = obj.getModified();
	}
}
