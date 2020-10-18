package com.dextra.challange.MarvelBackend.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Character implements Serializable {

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
	private String description;

	@Getter
	@Setter
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date modified;

	@Getter
	@Setter
	private String resourceURI;

	// privateurls (Array[Url], optional): A set of public web site URLs for the
	// resource.,

	@Getter
	@Setter
	private String thumbnail;

	public Character() {

	}

	public Character(String name, String description, Date modified, String resourceURI, String thumbnail) {
		super();
		this.name = name;
		this.description = description;
		this.modified = modified;
		this.resourceURI = resourceURI;
		this.thumbnail = thumbnail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Character other = (Character) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}