package com.mkyong;

import java.util.Map;

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

		String valor = arg2.toString();

		if (valor == null) {
			return;
		}
		String separador = getValorAtributo(arg1);
		patron = patron.replace("@", separador);
		if (!valor.matches(patron)) {
			throw new ValidatorException(new FacesMessage("El email no es correcto"));
		}

	}

	protected String getValorAtributo(UIComponent component) {
		Map<String, Object> attributes = component.getAttributes();
		String separador = (String) attributes.get("separador");
		return separador;
	}

	public void setPatron(String patron) {
		this.patron = patron;
	}
}
