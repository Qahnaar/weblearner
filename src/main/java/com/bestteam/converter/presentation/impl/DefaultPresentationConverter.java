package com.bestteam.converter.presentation.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bestteam.converter.presentation.PresentationConverter;
import com.bestteam.domain.Presentation;
import com.bestteam.dto.PresentationDto;

@Component("presentationConverter")
public class DefaultPresentationConverter implements PresentationConverter {

	@Override
	public PresentationDto convertToDto(Presentation entity) {
		PresentationDto dto = null;

		if (entity != null) {
			dto = new PresentationDto();
			dto.setId(entity.getId());
			dto.setLocation(entity.getLocation());
			dto.setName(entity.getName());
			dto.setWebinarId(entity.getWebinar().getId());

			List<String> slides = new ArrayList<String>();
			for (File slide : entity.getContent()) {
				slides.add(slide.getName());
			}
			dto.setSlideNames(slides);
		}

		return dto;
	}

	@Override
	public Presentation convertToEntity(PresentationDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
