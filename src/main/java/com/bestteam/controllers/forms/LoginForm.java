package com.bestteam.controllers.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

public class LoginForm {

	@NotNull
	@Email
	@Size(min = 5, max = 255)
	private String email;

	@NotNull
	@Size(min = 6, max = 255)
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
