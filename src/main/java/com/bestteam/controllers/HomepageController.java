package com.bestteam.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bestteam.services.webinar.WebinarService;

@Controller
@RequestMapping("/")
public class HomepageController {

	@Autowired
	private WebinarService webinarService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView homepageRetrieval(HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("index");

		modelAndView.addObject("pageTitle", "Homepage");
		modelAndView.addObject("featureWebinars", webinarService.getWebinars());

		return modelAndView;
	}
}
