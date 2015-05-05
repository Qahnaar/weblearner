package com.bestteam.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bestteam.dao.user.UserDao;
import com.bestteam.dao.webinar.WebinarDao;
import com.bestteam.domain.User;
import com.bestteam.domain.Webinar;
import com.bestteam.service.user.UserService;

@Service("userService")
public class DefaultUserService implements UserService {

	@Resource
	private UserDao userDao;

	@Resource
	private WebinarDao webinarDao;

	@Override
	public void save(User entity) {
		userDao.create(entity);
	}

	@Override
	public User get(long entityId) {
		return userDao.read(entityId);
	}

	@Override
	public void update(User entity) {
		userDao.update(entity);
	}

	@Override
	public void delete(User entity) {
		userDao.delete(entity);
	}

	@Override
	public List<User> getAll() {
		return userDao.readAll();
	}

	@Override
	public User getUserByEmail(String email) {
		User user = null;

		for (User persistentUser : userDao.readAll()) {
			if (persistentUser.getEmail().equals(email)) {
				user = persistentUser;
				break;
			}
		}

		return user;
	}

	@Override
	public User getLectorForWebinar(long webinarId) {
		User user = null;

		for (Webinar webinar : webinarDao.readAll()) {
			if (webinar.getId() == webinarId) {
				user = webinar.getLector();
				break;
			}
		}

		return user;
	}
}
