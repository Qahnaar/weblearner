package com.bestteam.converter.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bestteam.converter.user.UserConverter;
import com.bestteam.domain.User;
import com.bestteam.domain.Webinar;
import com.bestteam.dto.UserDto;

@Component("userConverter")
public class DefaultUserConverter implements UserConverter {

	@Override
	public UserDto convertToDto(User entity) {
		UserDto dto = null;

		if (entity != null) {
			dto = new UserDto();

			dto.setEmail(entity.getEmail());
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setPassword(entity.getPassword());

			List<Long> webinars = new ArrayList<Long>();
			for (Webinar webinar : entity.getWebinars()) {
				webinars.add(webinar.getId());
			}
			dto.setWebinarIds(webinars);
		}

		return dto;
	}

	@Override
	public User convertToEntity(UserDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
