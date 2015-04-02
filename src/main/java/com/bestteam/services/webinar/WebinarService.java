package com.bestteam.services.webinar;

import java.util.List;

import com.bestteam.domain.Webinar;

public interface WebinarService {
	Webinar getWebinars(long id);

	List<Webinar> getWebinars();
}
