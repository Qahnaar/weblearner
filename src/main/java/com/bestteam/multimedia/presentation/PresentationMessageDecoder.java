package com.bestteam.multimedia.presentation;

import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class PresentationMessageDecoder implements
		Decoder.Text<PresentationMessage> {
	@Override
	public void init(final EndpointConfig config) {
	}

	@Override
	public void destroy() {
	}

	@Override
	public PresentationMessage decode(final String slideName)
			throws DecodeException {
		PresentationMessage presentationMessage = new PresentationMessage();
		JsonObject obj = Json.createReader(new StringReader(slideName))
				.readObject();
		presentationMessage.setCurrentSlide(obj.getString("currentSlide"));
		presentationMessage.setSlideAction(obj.getString("slideAction"));
		presentationMessage.setPresentationName(obj
				.getString("presentationName"));
		presentationMessage.setWebinarId(obj.getString("webinarId"));

		return presentationMessage;
	}

	@Override
	public boolean willDecode(final String s) {
		return true;
	}
}
