package com.bestteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bestteam.controllers.base.WebLearnerController;
import com.bestteam.controllers.utils.ControllerConstants;
import com.bestteam.services.webinar.WebinarService;

@Controller
@RequestMapping(ControllerConstants.Views.DASHBOARD)
public class DashboardController extends WebLearnerController {

	private static final String FEATURED_WEBINARS = "featuredWebinars";
	@Autowired
	private WebinarService webinarService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView homepageRetrieval() {

		ModelAndView modelAndView = new ModelAndView(
				ControllerConstants.Pages.DASHBOARD);

		setUpPage(modelAndView, ControllerConstants.Pages.Titles.DASHBOARD);

		modelAndView.addObject(FEATURED_WEBINARS, webinarService.getWebinars());

		return modelAndView;
	}
}
