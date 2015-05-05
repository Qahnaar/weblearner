package com.bestteam.domain;

import java.io.File;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "presentations")
public class Presentation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "webinar_id")
	private Webinar webinar;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "location", nullable = false, length = 255)
	private String location;
	
	@Transient
	private List<File> content;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<File> getContent() {
		return content;
	}

	public void setContent(List<File> content) {
		this.content = content;
	}

	public Webinar getWebinar() {
		return webinar;
	}

	public void setWebinar(Webinar webinar) {
		this.webinar = webinar;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
