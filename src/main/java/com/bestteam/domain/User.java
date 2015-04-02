package com.bestteam.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private long id;

	@Column(name = "email", nullable = false, unique = true, length = 40)
	private String email;

	@Column(name = "pass", nullable = false, length = 40)
	private String password;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@OneToMany(mappedBy="lector", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Webinar> webinars;
	
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

	public List<Webinar> getWebinars() {
		return webinars;
	}

	public void setWebinars(List<Webinar> webinars) {
		this.webinars = webinars;
	}
}
