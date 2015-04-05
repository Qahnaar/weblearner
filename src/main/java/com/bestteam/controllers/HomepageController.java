package com.bestteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bestteam.controllers.utils.ControllerConstants;
import com.bestteam.services.webinar.WebinarService;

@Controller
@RequestMapping(ControllerConstants.Views.HOMEPAGE)
public class HomepageController extends WebLearnerController {

	@Autowired
	private WebinarService webinarService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView homepageRetrieval() {

		ModelAndView modelAndView = new ModelAndView(
				ControllerConstants.Pages.HOMEPAGE);

		setUpPage(modelAndView, ControllerConstants.Pages.Titles.HOMEPAGE);

		modelAndView
				.addObject("featuredWebinars", webinarService.getWebinars());

		return modelAndView;
	}
}
