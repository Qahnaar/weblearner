package com.bestteam.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bestteam.controller.base.WebLearnerController;
import com.bestteam.controller.utils.ControllerConstants;
import com.bestteam.dto.UserDto;
import com.bestteam.dto.WebinarDto;
import com.bestteam.facade.user.UserFacade;
import com.bestteam.facade.webinar.WebinarFacade;

@Controller
@RequestMapping(ControllerConstants.Mappings.WEBINAR)
public class WebinarController extends WebLearnerController {

	private static final String WEBINAR = "webinar";

	@Autowired
	private WebinarFacade webinarFacade;

	@Autowired
	private UserFacade userFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getWebinar(@PathVariable long id, HttpSession session) {

		WebinarDto webinar = webinarFacade.get(id);
		webinar.setLector(userFacade.getLectorForWebinar(id));

		UserDto loggedUser = (UserDto) session
				.getAttribute(ControllerConstants.GeneralConstants.LOGGEDIN_USER);

		ModelAndView modelAndView = null;

		if (webinar.getLector().getEmail().equals(loggedUser.getEmail())) {
			modelAndView = new ModelAndView(
					ControllerConstants.Pages.LECTOR_WEBINAR);
		} else {
			modelAndView = new ModelAndView(
					ControllerConstants.Pages.VISITOR_WEBINAR);
		}

		setUpPage(modelAndView, webinar.getName());

		modelAndView.addObject(WEBINAR, webinar);

		return modelAndView;
	}
}
