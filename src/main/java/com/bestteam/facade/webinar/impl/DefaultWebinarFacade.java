package com.bestteam.facade.webinar.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bestteam.converter.webinar.WebinarConverter;
import com.bestteam.domain.Webinar;
import com.bestteam.dto.WebinarDto;
import com.bestteam.facade.webinar.WebinarFacade;
import com.bestteam.service.webinar.WebinarService;

@Component("webinarFacade")
public class DefaultWebinarFacade implements WebinarFacade {

	@Resource
	private WebinarService webinarService;

	@Resource
	private WebinarConverter webinarConverter;

	@Override
	public void save(Webinar entity) {
		webinarService.save(entity);
	}

	@Override
	public WebinarDto get(long entityId) {
		return webinarConverter.convertToDto(webinarService.get(entityId));
	}

	@Override
	public void update(Webinar entity) {
		webinarService.update(entity);
	}

	@Override
	public void delete(Webinar entity) {
		webinarService.delete(entity);
	}

	@Override
	public List<WebinarDto> getAll() {
		List<WebinarDto> webinarDtos = new ArrayList<WebinarDto>();

		for (Webinar webinar : webinarService.getAll()) {
			webinarDtos.add(webinarConverter.convertToDto(webinar));
		}

		return webinarDtos;
	}
}
