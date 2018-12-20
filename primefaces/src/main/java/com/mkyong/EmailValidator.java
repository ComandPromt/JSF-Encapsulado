package com.mkyong;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("EmailValidator")
public class EmailValidator implements Validator {

	private String patron;

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {

		String valor = (String) arg2;

		if (valor == null) {
			return;
		}

		if (!valor.matches(patron)) {
			throw new ValidatorException(new FacesMessage("El email no es correcto"));
		}

	}

	public void setPatron(String patron) {
		this.patron = patron;
	}
}
