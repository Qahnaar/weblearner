package com.bestteam.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.bestteam.domain.User;
import com.bestteam.services.UserService;


@Service("userService")
public class UserServiceMockUp implements UserService {

	private Map<String, User> userMap;

	@PostConstruct
	public void setUp() {
		userMap = new HashMap<String, User>();
		userMap.put("Qahnaar",
				constructUser("romanmarkhyvka@gmail.com", "111111"));
		userMap.put("Serge",
				constructUser("sergepasternak@gmail.com", "111111"));
		userMap.put("Iirui",
				constructUser("iiruiparfeniuk@gmail.com", "111111"));
	}

	@Override
	public User getUser(String login) {
		return userMap.get(login);
	}

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		
		for (Entry<String, User> user : userMap.entrySet()) {
			users.add(user.getValue());
		}
		
		return users;
	}

	private User constructUser(String email, String password) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		return user;
	}
}