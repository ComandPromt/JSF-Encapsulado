package com.mkyong;

import lombok.Data;

@Data
public class Email {
	private final String usuario;
	private final String dominio;

	@Override
	public String toString() {
		return usuario + "@" + dominio;
	}

}
