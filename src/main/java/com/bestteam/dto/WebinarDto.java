package com.bestteam.dto;

import java.util.Date;
import java.util.List;

public class WebinarDto {

	private long webinarId;

	private String name;

	private String description;

	private String agenda;

	private List<String> attachmentNames;

	private List<String> presentationNames;

	private UserDto lector;

	private boolean isArchived;

	private Date startDate;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}

	public List<String> getAttachmentNames() {
		return attachmentNames;
	}

	public void setAttachmentNames(List<String> attachmentNames) {
		this.attachmentNames = attachmentNames;
	}

	public List<String> getPresentationNames() {
		return presentationNames;
	}

	public void setPresentationNames(List<String> presentationNames) {
		this.presentationNames = presentationNames;
	}

	public UserDto getLector() {
		return lector;
	}

	public void setLector(UserDto lector) {
		this.lector = lector;
	}

	public boolean isArchived() {
		return isArchived;
	}

	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
