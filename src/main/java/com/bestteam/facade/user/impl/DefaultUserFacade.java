package com.bestteam.facade.user.impl;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.bestteam.converter.user.UserConverter;
import com.bestteam.domain.User;
import com.bestteam.dto.UserDto;
import com.bestteam.facade.user.UserFacade;
import com.bestteam.service.user.UserService;

@Component("userFacade")
public class DefaultUserFacade implements UserFacade {

	private final static Logger LOG = LoggerFactory
			.getLogger(DefaultUserFacade.class);

	@Resource
	private UserService userService;

	@Resource
	private UserConverter userConverter;

	@Override
	public void save(User entity) {
		userService.save(entity);
	}

	@Override
	public UserDto get(long entityId) {
		return userConverter.convertToDto(userService.get(entityId));
	}

	@Override
	public void update(User entity) {
		userService.update(entity);
	}

	@Override
	public void delete(User entity) {
		userService.delete(entity);
	}

	@Override
	public List<UserDto> getAll() {
		List<UserDto> userDtos = new ArrayList<UserDto>();

		for (User user : userService.getAll()) {
			userDtos.add(userConverter.convertToDto(user));
		}

		return userDtos;
	}

	@Override
	public UserDto checkUserCredentials(String email, String password) {
		User user = userService.getUserByEmail(email);

		if (!password.equals(user.getPassword())) {
			LOG.debug(MessageFormat.format(
					"Invalid credentials for email: {0}, password {1}", email,
					password));
			user = null;
		}

		return userConverter.convertToDto(user);
	}

	@Override
	public UserDto getLectorForWebinar(long webinarId) {
		return userConverter.convertToDto(userService
				.getLectorForWebinar(webinarId));
	}
}
