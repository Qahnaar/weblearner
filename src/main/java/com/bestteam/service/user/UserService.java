package com.bestteam.service.user;

import com.bestteam.domain.User;
import com.bestteam.service.WebLearnerService;

public interface UserService extends WebLearnerService<User> {

	User getUserByEmail(String email);

	User getLectorForWebinar(long webinarId);
}