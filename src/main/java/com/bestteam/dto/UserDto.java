package com.bestteam.dto;

import java.util.List;

public class UserDto {

	private long id;

	private String email;

	private String password;

	private String name;

	private List<Long> webinarIds;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Long> getWebinarIds() {
		return webinarIds;
	}

	public void setWebinarIds(List<Long> webinarIds) {
		this.webinarIds = webinarIds;
	}
}
