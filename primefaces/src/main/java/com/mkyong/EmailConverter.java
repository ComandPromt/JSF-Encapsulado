package com.mkyong;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("com.mkyong.EmailConverter")
public class EmailConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		String separador = getValorAtributo(component);
		String[] aux = value.split(separador);
		if (aux.length == 2) {
			return new Email(aux[0], aux[1]);
		}

		throw new ConverterException(new FacesMessage("\nNo contiene usuario" + separador + "dominio"));
	}

	protected String getValorAtributo(UIComponent component) {
		Map<String, Object> attributes = component.getAttributes();
		String separador = (String) attributes.get("separador");
		return separador;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value == null) {
			return null;
		}

		if (value instanceof Email) {
			return value.toString();
		}
		throw new ConverterException(new FacesMessage("No es un objeto de la clase Email"));

	}

}
