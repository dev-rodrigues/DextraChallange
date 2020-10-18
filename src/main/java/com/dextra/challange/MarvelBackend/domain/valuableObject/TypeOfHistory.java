package com.dextra.challange.MarvelBackend.domain.valuableObject;

import lombok.Getter;

public enum TypeOfHistory {
	INTERIOR(1, "Interior"), 
	COVER(2, "Cover");

	@Getter
	private int cod;

	@Getter
	private String description;

	private TypeOfHistory(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public static TypeOfHistory toEnum(Integer cod) {
		if (cod == null) return null;

		for (TypeOfHistory type : TypeOfHistory.values()) {
			if (cod.equals(type)) return type;
		}

		throw new IllegalArgumentException("Inválid Cod: " + cod);
	}
}
