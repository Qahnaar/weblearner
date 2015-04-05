package com.bestteam.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bestteam.controllers.base.WebLearnerController;
import com.bestteam.controllers.utils.ControllerConstants;
import com.bestteam.domain.Webinar;
import com.bestteam.services.webinar.WebinarService;

@Controller
@RequestMapping(ControllerConstants.Views.WEBINAR)
public class WebinarController extends WebLearnerController {

	private static final String WEBINAR = "webinar";
	@Autowired
	private WebinarService webinarService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView homepageRetrieval(@PathVariable long id) {

		ModelAndView modelAndView = new ModelAndView(
				ControllerConstants.Pages.WEBINAR);

		Webinar webinar = webinarService.getWebinars(id);

		setUpPage(modelAndView, webinar.getName());

		modelAndView.addObject(WEBINAR, webinar);

		return modelAndView;
	}
}
