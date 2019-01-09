
package com.mkyong;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class EmailTest {
	@Test
	public void deberiaSetearUnUsuario() throws Exception {
		Email prueba = new Email("Usuario", null, "@");

		assertThat(prueba.getUsuario(), equalTo("Usuario"));

	}

	@Test
	public void deberiaSetearUnDominio() throws Exception {
		Email prueba = new Email(null, "Dominio", "@");
		assertThat(prueba.getDominio(), equalTo("Dominio"));

	}

	@Test
	public void deberiaSerIguales() throws Exception {
		Email emailA = new Email("usuarioA", "dominioA", "@");
		Email emailB = new Email("usuarioA", "dominioA", "@");
		assertThat(emailA, is(emailB));

	}

}
