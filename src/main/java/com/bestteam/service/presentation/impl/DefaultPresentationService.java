package com.bestteam.service.presentation.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.bestteam.dao.presentation.PresentationDao;
import com.bestteam.domain.Presentation;
import com.bestteam.exception.SlideSaveException;
import com.bestteam.service.presentation.PresentationService;

@Service("presentationService")
public class DefaultPresentationService implements PresentationService {

	private static final String SAVING_SLIDE_EXCEPTPION_MESSAGE = "Error saving slide";

	private final static Logger LOG = LoggerFactory
			.getLogger(DefaultPresentationService.class);

	@Resource
	private PresentationDao presentationDao;

	@Override
	public void save(Presentation entity) {
		presentationDao.create(entity);
	}

	@Override
	public Presentation get(long entityId) {
		return presentationDao.read(entityId);
	}

	@Override
	public void update(Presentation entity) {
		presentationDao.update(entity);
	}

	@Override
	public void delete(Presentation entity) {
		presentationDao.delete(entity);
	}

	@Override
	public List<Presentation> getAll() {
		return presentationDao.readAll();
	}

	@Override
	public void saveSlide(File slide) throws SlideSaveException {
		try {
			presentationDao.createSlide(slide);
		} catch (IOException e) {
			LOG.debug(SAVING_SLIDE_EXCEPTPION_MESSAGE, e);
			throw new SlideSaveException(SAVING_SLIDE_EXCEPTPION_MESSAGE, e);
		}
	}

	@Override
	public File getSlide(String slidePath) {
		return presentationDao.readSlide(slidePath);
	}

	@Override
	public Presentation getPresentationByName(String name) {
		return presentationDao.getPresentationByName(name);
	}

	@Override
	public List<Presentation> getPresentationsForWebinar(long webinarId) {
		return presentationDao.getPresentationsForWebinar(webinarId);
	}
}
