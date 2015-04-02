package com.bestteam.services.webinar.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bestteam.domain.User;
import com.bestteam.domain.Webinar;
import com.bestteam.services.user.UserService;
import com.bestteam.services.webinar.WebinarService;

@Service(value = "webinarService")
public class WebinarServiceMockUp implements WebinarService {

	@Autowired
	private UserService userService;

	private Map<Long, Webinar> webinarMap;

	private Calendar calendar;

	@PostConstruct
	public void setUp() {
		calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);

		User firstLector = userService.getUser(1);
		User secondLector = userService.getUser(2);

		webinarMap = new HashMap<Long, Webinar>();

		webinarMap.put(
				1L,
				constructWebinar(1, "1st Webinar", "1st Webinar Description",
						"1st Webinar Agenda", firstLector));
		webinarMap.put(
				2L,
				constructWebinar(2, "2nd Webinar", "2nd Webinar Description",
						"2nd Webinar Agenda", firstLector));
		webinarMap.put(
				3L,
				constructWebinar(3, "3rd Webinar", "3rd Webinar Description",
						"3rd Webinar Agenda", secondLector));
		webinarMap.put(
				4L,
				constructWebinar(4, "4th Webinar", "4th Webinar Description",
						"4th Webinar Agenda", firstLector));
		webinarMap.put(
				5L,
				constructWebinar(5, "5th Webinar", "5th Webinar Description",
						"5th Webinar Agenda", firstLector));
		webinarMap.put(
				6L,
				constructWebinar(6, "6th Webinar", "6th Webinar Description",
						"6th Webinar Agenda", secondLector));
		webinarMap.put(
				7L,
				constructWebinar(7, "7th Webinar", "7th Webinar Description",
						"7th Webinar Agenda", firstLector));
		webinarMap.put(
				8L,
				constructWebinar(8, "8th Webinar", "8th Webinar Description",
						"8th Webinar Agenda", firstLector));
		webinarMap.put(
				9L,
				constructWebinar(9, "9th Webinar", "9th Webinar Description",
						"9th Webinar Agenda", firstLector));
		webinarMap.put(
				10L,
				constructWebinar(10, "10th Webinar",
						"10th Webinar Description", "10th Webinar Agenda",
						firstLector));
	}

	@Override
	public Webinar getWebinars(long id) {
		return webinarMap.get(id);
	}

	@Override
	public List<Webinar> getWebinars() {
		List<Webinar> webinars = new ArrayList<Webinar>();

		for (Entry<Long, Webinar> webinar : webinarMap.entrySet()) {
			webinars.add(webinar.getValue());
		}

		return webinars;
	}

	private Webinar constructWebinar(long id, String name, String description,
			String agenda, User lector) {
		Webinar webinar = new Webinar();

		webinar.setId(id);
		webinar.setName(name);
		webinar.setDescription(description);
		webinar.setAgenda(agenda);
		webinar.setLector(lector);
		webinar.setStartDate(calendar.getTime());

		return webinar;
	}
}
