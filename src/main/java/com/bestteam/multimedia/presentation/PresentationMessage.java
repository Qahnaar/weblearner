package com.bestteam.multimedia.presentation;

public class PresentationMessage {
	private String currentSlide;
	private String slideAction;
	private String presentationName;
	private String webinarId;

	public String getPresentationName() {
		return presentationName;
	}

	public void setPresentationName(String presentationName) {
		this.presentationName = presentationName;
	}

	public String getWebinarId() {
		return webinarId;
	}

	public void setWebinarId(String webinarId) {
		this.webinarId = webinarId;
	}

	public String getCurrentSlide() {
		return currentSlide;
	}

	public void setCurrentSlide(String currentSlide) {
		this.currentSlide = currentSlide;
	}

	public String getSlideAction() {
		return slideAction;
	}

	public void setSlideAction(String slideAction) {
		this.slideAction = slideAction;
	}
}
