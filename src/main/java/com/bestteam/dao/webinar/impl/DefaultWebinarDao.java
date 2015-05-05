package com.bestteam.dao.webinar.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bestteam.dao.webinar.WebinarDao;
import com.bestteam.domain.Webinar;

@Repository("webinarDao")
@Transactional
public class DefaultWebinarDao implements WebinarDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void create(Webinar entity) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(entity);
		tx.commit();
		session.close();
	}

	@Override
	public Webinar read(long entityId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Webinar webinar = (Webinar) session.get(Webinar.class, entityId);
		tx.commit();
		session.close();

		return webinar;
	}

	@Override
	public void update(Webinar entity) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(Webinar entity) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Webinar> readAll() {
		List<Webinar> webinars = Collections.EMPTY_LIST;
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Webinar");
		webinars = query.list();
		tx.commit();
		session.close();

		return webinars;
	}
}
