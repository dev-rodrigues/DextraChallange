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
}