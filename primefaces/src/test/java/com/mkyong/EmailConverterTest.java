package com.mkyong;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import javax.faces.component.UIComponent;
import javax.faces.convert.ConverterException;

import org.junit.Before;
import org.junit.Test;

public class EmailConverterTest {
	private EmailConverter conversor;
	private EmailConverter conversorSpy;

	private UIComponent componente;

	@Before
	public void inicializarEnCadaTest() {
		this.componente = mock(UIComponent.class);
		conversor = new EmailConverter();
		conversorSpy = spy(conversor);

		doReturn("@").when(conversorSpy).getValorAtributo(componente);
	}

	@Test
	public void dadoUnaCadenaDevuelveUnEmail() throws Exception {
		String email = "usuario@dominio";

		Email resultado = (Email) conversorSpy.getAsObject(null, componente, email);

		assertThat(resultado.getUsuario(), is("usuario"));
		assertThat(resultado.getDominio(), is("dominio"));
	}

	@Test(expected = ConverterException.class)
	public void dadoUnaCadenaSinArrobaDeberiaLanzarConverterException() throws Exception {
		conversorSpy.getAsObject(null, componente, "usuario_dominio");
	}

	@Test
	public void dadoUnValorNuloDevuelveNulo() throws Exception {
		assertThat(conversorSpy.getAsObject(null, componente, null), is(nullValue()));
	}

	@Test(expected = ConverterException.class)
	public void tiraUnErrorDeConversionCadenaVacia() throws Exception {
		conversorSpy.getAsObject(null, componente, "");
	}

	@Test(expected = ConverterException.class)
	public void tiraUnErrorDeConversionSiNoTengoDominio() throws Exception {
		conversorSpy.getAsObject(null, componente, "@");
	}

	@Test
	public void dadoUnEmailDevuelveCadena() throws Exception {
		Email email = new Email("usuario", "dominio");
		String comprobar = conversorSpy.getAsString(null, null, email);
		assertThat(comprobar, is("usuario@dominio"));
	}

	@Test
	public void dadoUnEmailNuloDevuelveNulo() throws Exception {
		String comprobar = conversorSpy.getAsString(null, null, null);
		assertThat(comprobar, is(nullValue()));

	}

	@Test(expected = ConverterException.class)
	public void compruebaUnObjetoQueNoEsEmailDevuelveExepcion() throws Exception {
		conversorSpy.getAsString(null, null, new Object());

	}

}
