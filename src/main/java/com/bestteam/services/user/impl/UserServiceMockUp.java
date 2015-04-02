package com.bestteam.services.user.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.bestteam.domain.User;
import com.bestteam.services.user.UserService;

@Service("userService")
public class UserServiceMockUp implements UserService {

	private Map<Long, User> userMap;

	@PostConstruct
	public void setUp() {
		userMap = new HashMap<Long, User>();
		userMap.put(1L,
				constructUser(1, "romanmarkhyvka@gmail.com", "Roman Markhyvka"));
		userMap.put(2L,
				constructUser(2, "sergepasternak@gmail.com", "Serge Pasternak"));
		userMap.put(3L,
				constructUser(3, "iiruiparfeniuk@gmail.com", "Iurii Parfeniuk"));
	}

	@Override
	public User getUser(long id) {
		return userMap.get(id);
	}

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();

		for (Entry<Long, User> user : userMap.entrySet()) {
			users.add(user.getValue());
		}

		return users;
	}

	private User constructUser(long id, String email, String name) {
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setName(name);
		return user;
	}
}