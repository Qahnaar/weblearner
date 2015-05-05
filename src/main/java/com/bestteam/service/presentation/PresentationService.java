package com.bestteam.service.presentation;

import java.io.File;
import java.util.List;

import com.bestteam.domain.Presentation;
import com.bestteam.exception.SlideSaveException;
import com.bestteam.service.WebLearnerService;

public interface PresentationService extends WebLearnerService<Presentation> {

	Presentation getPresentationByName(String name);

	List<Presentation> getPresentationsForWebinar(long webinarId);

	void saveSlide(File slide) throws SlideSaveException;

	File getSlide(String slidePath);
}
