package com.bestteam.multimedia.presentation;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class PresentationMessageEncoder implements
		Encoder.Text<PresentationMessage> {

	@Override
	public void init(final EndpointConfig config) {
	}

	@Override
	public void destroy() {
	}

	@Override
	public String encode(final PresentationMessage presentationMessage)
			throws EncodeException {
		return Json
				.createObjectBuilder()
				.add("currentName", presentationMessage.getCurrentSlide())
				.add("slideAction", presentationMessage.getSlideAction())
				.add("webinarId", presentationMessage.getWebinarId())
				.add("presentationName",
						presentationMessage.getPresentationName()).build()
				.toString();
	}
}