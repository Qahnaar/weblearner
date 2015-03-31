package com.bestteam.services;

import java.util.List;

import com.bestteam.domain.User;

public interface UserService {
	User getUser(String login);
	
	List<User> getUsers();
}