package com.bestteam.chat;

import java.text.SimpleDateFormat;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class ChatMessageEncoder implements Encoder.Text<ChatMessage> {

	private SimpleDateFormat formatter;

	@Override
	public void init(final EndpointConfig config) {
		formatter = new SimpleDateFormat("hh:mm");
	}

	@Override
	public void destroy() {
	}

	@Override
	public String encode(final ChatMessage chatMessage) throws EncodeException {
		return Json.createObjectBuilder()
				.add("message", chatMessage.getMessage())
				.add("sender", chatMessage.getSender())
				.add("received", formatter.format(chatMessage.getReceived()))
				.build().toString();
	}
}