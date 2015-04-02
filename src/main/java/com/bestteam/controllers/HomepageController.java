package com.bestteam.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bestteam.services.user.UserService;

@Controller
@RequestMapping("/")
public class HomepageController {
	
	private final static Logger LOG = LoggerFactory.getLogger(HomepageController.class);

	@Autowired
	private UserService userService;


	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void loginPost(@RequestParam(value = "login") String login) {
		LOG.info("POST with" + login);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login() {

	}
}
