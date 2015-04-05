package com.bestteam.controllers;

import org.springframework.web.servlet.ModelAndView;

public class WebLearnerController {

	private static final String PAGE_TITLE = "pageTitle";

	public void setUpPage(ModelAndView model, String pageTitle) {
		model.addObject(PAGE_TITLE, pageTitle);
	}
}
