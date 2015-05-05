package com.bestteam.dao.user.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bestteam.dao.user.UserDao;
import com.bestteam.domain.User;

@Repository("userDao")
@Transactional
public class DefaultUserDao implements UserDao {

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void create(User entity) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(entity);
		tx.commit();
		session.close();
	}

	@Override
	public User read(long entityId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		User user = (User) session.get(User.class, entityId);
		tx.commit();
		session.close();

		return user;
	}

	@Override
	public void update(User entity) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(entity);
		tx.commit();
		session.close();
	}

	@Override
	public void delete(User entity) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);
		tx.commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> readAll() {
		List<User> users = new ArrayList<User>();
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Query query = session.createQuery("from User");
		users = query.list();
		tx.commit();
		session.close();

		return users;
	}
}
