package com.dextra.challange.MarvelBackend.exception.resource;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Long timeStamp;
	
	@Getter
	@Setter
	private Integer status;

	@Getter
	@Setter
	private String error;

	@Getter
	@Setter
	private String message;

	@Getter
	@Setter
	private String path;

	public StandardError(Long timeStamp, Integer status, String error, String message, String path) {
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
}