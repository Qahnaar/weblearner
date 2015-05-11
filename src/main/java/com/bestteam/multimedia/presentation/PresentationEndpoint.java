package com.bestteam.multimedia.presentation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.websocket.EncodeException;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/presentation/{room}", encoders = PresentationMessageEncoder.class, decoders = PresentationMessageDecoder.class)
public class PresentationEndpoint {

	private final static Logger LOG = Logger
			.getLogger(PresentationEndpoint.class.getName());

	private static List<Session> openedSessions = new ArrayList<Session>();

	@OnOpen
	public void open(final Session session, @PathParam("room") final String room) {
		LOG.info("Presentation session opened and bound to room: " + room);
		session.getUserProperties().put("room", room);
		openedSessions.add(session);
	}

	@OnMessage
	public void onMessage(final Session session,
			final PresentationMessage presentationMessage) {
		String room = (String) session.getUserProperties().get("room");
		try {
			for (Session s : openedSessions) {
				if (s.isOpen()
						&& room.equals(s.getUserProperties().get("room"))) {
					s.getBasicRemote().sendObject(presentationMessage);
				}
			}
		} catch (IOException | EncodeException e) {
			LOG.info("onMessage failed: " + e);
		}
	}
}