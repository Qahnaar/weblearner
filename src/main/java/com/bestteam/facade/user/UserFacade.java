package com.bestteam.facade.user;

import com.bestteam.domain.User;
import com.bestteam.dto.UserDto;
import com.bestteam.facade.WebLearnerFacade;

public interface UserFacade extends WebLearnerFacade<User, UserDto> {

	UserDto checkUserCredentials(String email, String password);

	UserDto getLectorForWebinar(long webinarId);
}
