package com.bestteam.controller.base;

import org.springframework.web.servlet.ModelAndView;

public class WebLearnerController {

	private static final String PAGE_TITLE = "pageTitle";

	public static final String APPLICATION_ROOT = "/weblearner";
	
	public static final String REDIRECT_PREFIX = "redirect:";
	
	public void setUpPage(ModelAndView model, String pageTitle) {
		model.addObject(PAGE_TITLE, pageTitle);
	}
}
