package com.bestteam.service.webinar.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bestteam.dao.webinar.WebinarDao;
import com.bestteam.domain.Webinar;
import com.bestteam.service.webinar.WebinarService;

@Service("webinarService")
public class DefaultWebinarService implements WebinarService {

	@Resource
	private WebinarDao webinarDao;

	@Override
	public void save(Webinar entity) {
		webinarDao.create(entity);
	}

	@Override
	public Webinar get(long entityId) {
		return webinarDao.read(entityId);
	}

	@Override
	public void update(Webinar entity) {
		webinarDao.update(entity);
	}

	@Override
	public void delete(Webinar entity) {
		webinarDao.delete(entity);
	}

	@Override
	public List<Webinar> getAll() {
		return webinarDao.readAll();
	}
}
