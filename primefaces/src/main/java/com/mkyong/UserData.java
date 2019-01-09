package com.mkyong;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class UserData implements Serializable {
	private static final long serialVersionUID = 1L;
	public Date date;
	public Email email;

	public Date getDate() {
		return date;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}