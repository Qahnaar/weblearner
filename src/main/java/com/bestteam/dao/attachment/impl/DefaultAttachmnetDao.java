package com.bestteam.dao.attachment.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bestteam.dao.attachment.AttachmnetDao;
import com.bestteam.domain.Attachment;

@Repository("attachmentDao")
@Transactional
public class DefaultAttachmnetDao implements AttachmnetDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void create(Attachment entity) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(entity);
		tx.commit();
		session.close();
	}

	@Override
	public Attachment read(long entityId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Attachment attachment = (Attachment) session.get(Attachment.class,
				entityId);
		tx.commit();
		session.close();

		return attachment;
	}

	@Override
	public void update(Attachment entity) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(Attachment entity) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Attachment> readAll() {
		List<Attachment> attachments = Collections.EMPTY_LIST;
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from Attachment");
		attachments = query.list();
		tx.commit();
		session.close();

		return attachments;
	}
}
