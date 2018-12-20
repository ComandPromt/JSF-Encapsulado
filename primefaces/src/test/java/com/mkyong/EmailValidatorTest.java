package com.mkyong;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import javax.faces.validator.ValidatorException;

public class EmailValidatorTest {
	
@Test
public void deberiaValidarUnEmail() throws Exception{
	
	EmailValidator prueba=new EmailValidator();
	String comprobarEmail="nombre@email.com";
	
	prueba.setPatron("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
	
	prueba.validate(null, null, comprobarEmail);
}

@Test(expected=ValidatorException.class)
public void deberiaDarErrorUnEmail() throws Exception{
	
	EmailValidator prueba=new EmailValidator();
	String comprobarEmail="nombre@.com";
	
	prueba.setPatron("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$");
	prueba.validate(null, null, comprobarEmail);
}

@Test
public void deberiaDarNuloUnEmail() throws Exception{
	
	EmailValidator prueba=new EmailValidator();
	prueba.validate(null, null, null);
	assertEquals(null, "null");
}

}
