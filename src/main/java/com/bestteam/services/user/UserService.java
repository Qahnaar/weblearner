package com.bestteam.services.user;

import java.util.List;

import com.bestteam.domain.User;

public interface UserService {
	User getUser(long id);
	
	List<User> getUsers();
}