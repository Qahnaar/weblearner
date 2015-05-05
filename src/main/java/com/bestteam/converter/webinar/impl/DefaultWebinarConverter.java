package com.bestteam.converter.webinar.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bestteam.converter.webinar.WebinarConverter;
import com.bestteam.domain.Attachment;
import com.bestteam.domain.Presentation;
import com.bestteam.domain.Webinar;
import com.bestteam.dto.WebinarDto;

@Component("webinarConverter")
public class DefaultWebinarConverter implements WebinarConverter {

	@Override
	public WebinarDto convertToDto(Webinar entity) {
		WebinarDto dto = null;

		if (entity != null) {
			dto = new WebinarDto();

			dto.setWebinarId(entity.getId());
			dto.setAgenda(entity.getAgenda());
			dto.setArchived(entity.isArchived());
			dto.setDescription(entity.getDescription());
			dto.setStartDate(entity.getStartDate());
			dto.setName(entity.getName());

			List<String> attachments = new ArrayList<String>();
			for (Attachment attachment : entity.getAttachments()) {
				attachments.add(attachment.getName());
			}
			dto.setAttachmentNames(attachments);

			List<String> presentations = new ArrayList<String>();
			for (Presentation presentation : entity.getPresentations()) {
				presentations.add(presentation.getName());
			}
			dto.setPresentationNames(presentations);
		}

		return dto;
	}

	@Override
	public Webinar convertToEntity(WebinarDto dto) {
		return null;
	}
}
