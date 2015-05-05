package com.bestteam.multimedia.presentation;

import java.io.IOException;

import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ServerEndpoint(value = "/presentation/{room}", encoders = PresentationMessageEncoder.class, decoders = PresentationMessageDecoder.class)
public class PresentationEndpoint {
	private final static Logger LOG = LoggerFactory
			.getLogger(PresentationEndpoint.class);

	@OnOpen
	public void open(final Session session, @PathParam("room") final String room) {
		LOG.debug("Presentation session opened and bound to room: " + room);
		session.getUserProperties().put("room", room);
	}

	@OnMessage
	public void onMessage(final Session session,
			final PresentationMessage presentationMessage) {
		String room = (String) session.getUserProperties().get("room");
		try {
			for (Session s : session.getOpenSessions()) {
				if (s.isOpen()
						&& room.equals(s.getUserProperties().get("room"))) {
					s.getBasicRemote().sendObject(presentationMessage);
				}
			}
		} catch (IOException | EncodeException e) {
			LOG.debug("onMessage failed: " + e);
		}
	}
}