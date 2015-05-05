package com.bestteam.dto;

import java.util.List;

public class PresentationDto {

	private long id;

	private long webinarId;

	private String name;

	private String location;

	private List<String> slideNames;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getWebinarId() {
		return webinarId;
	}

	public void setWebinarId(long webinarId) {
		this.webinarId = webinarId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<String> getSlideNames() {
		return slideNames;
	}

	public void setSlideNames(List<String> slideNames) {
		this.slideNames = slideNames;
	}
}
