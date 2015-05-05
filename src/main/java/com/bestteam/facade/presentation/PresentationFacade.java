package com.bestteam.facade.presentation;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bestteam.domain.Presentation;
import com.bestteam.dto.PresentationDto;
import com.bestteam.exception.SlideSaveException;
import com.bestteam.facade.WebLearnerFacade;

public interface PresentationFacade extends
		WebLearnerFacade<Presentation, PresentationDto> {

	List<PresentationDto> getPresentationsForWebinar(long webinarId);

	PresentationDto saveSlides(long webinarId, MultipartFile presentation)
			throws SlideSaveException;

	void loadSlides(Presentation presentation);
}
