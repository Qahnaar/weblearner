package com.bestteam.dao.presentation.impl;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bestteam.dao.presentation.PresentationDao;
import com.bestteam.domain.Presentation;
import com.bestteam.domain.Webinar;

@Repository("presentationDao")
@Transactional
public class DefaultPresentationDao implements PresentationDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void create(Presentation entity) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(entity);
		tx.commit();
		session.close();
	}

	@Override
	public Presentation read(long entityId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Presentation presentation = (Presentation) session.get(
				Presentation.class, entityId);
		tx.commit();
		session.close();

		return presentation;
	}

	@Override
	public void update(Presentation entity) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(Presentation entity) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Presentation> readAll() {
		List<Presentation> presentation = Collections.EMPTY_LIST;
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Presentation");
		presentation = query.list();
		tx.commit();
		session.close();

		return presentation;
	}

	@Override
	public void createSlide(File file) throws IOException {
		File parentFile = file.getParentFile();
		parentFile.mkdirs();
		file.createNewFile();
	}

	@Override
	public File readSlide(String slidePath) {
		return new File(slidePath);
	}

	@Override
	public Presentation getPresentationByName(String name) {
		Criteria criteria = this.sessionFactory.openSession().createCriteria(
				Presentation.class);
		return (Presentation) criteria.add(Restrictions.eq("name", name))
				.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Presentation> getPresentationsForWebinar(long webinarId) {
		Criteria criteria = this.sessionFactory.openSession().createCriteria(
				Presentation.class);
		Webinar webinar = new Webinar();
		webinar.setId(webinarId);
		return criteria.add(Restrictions.eq("webinar", webinar)).list();
	}
}
