package com.bestteam.dao.presentation;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.bestteam.dao.WebLearnerDao;
import com.bestteam.domain.Presentation;

public interface PresentationDao extends WebLearnerDao<Presentation> {
	
	Presentation getPresentationByName(String name);
	
	List<Presentation> getPresentationsForWebinar(long webinarId);
	
	void createSlide(File file) throws IOException;

	File readSlide(String slidePath);
}
