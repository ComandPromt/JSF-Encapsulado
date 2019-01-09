package com.mkyong;

import lombok.Data;

@Data
public class Email {
	private final String usuario;
	private final String dominio;
	private final String separador;

	@Override
	public String toString() {
		return usuario + separador + dominio;
	}

}
