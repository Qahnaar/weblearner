package com.bestteam.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bestteam.controllers.utils.ControllerConstants;
import com.bestteam.services.user.UserService;

@Controller
@RequestMapping(ControllerConstants.Views.REGISTER)
public class RegisterController {

	private final static Logger LOG = LoggerFactory
			.getLogger(RegisterController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public void registerGet() {
		System.out.println("Register GET");
	}

	@RequestMapping(method = RequestMethod.POST)
	public void registerPost(@RequestParam(value = "login") String login) {
		System.out.println("Register POST");
	}
}
