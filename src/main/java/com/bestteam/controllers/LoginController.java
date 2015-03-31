package com.bestteam.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bestteam.services.UserService;

@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(@RequestParam("login") String login) throws Exception {
		login = new ObjectMapper().readValue(login, String.class);
		// String login = request.getParameter("login");
		System.out.println(userService.getUser(login).getEmail());
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login1() {
		System.out.println(userService.getUser("Qahnaar").getEmail());
		return "index";
	}
}
