package com.bestteam.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bestteam.controller.base.WebLearnerController;
import com.bestteam.controller.forms.LoginForm;
import com.bestteam.controller.utils.ControllerConstants;
import com.bestteam.dto.UserDto;
import com.bestteam.facade.user.UserFacade;

@Controller
@RequestMapping(ControllerConstants.Mappings.LOGIN)
public class LoginController extends WebLearnerController {

	private static final String HOME_LINK = "homeLink";

	@Autowired
	private UserFacade userFacade;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loginGet() {
		ModelAndView modelAndView = new ModelAndView(
				ControllerConstants.Pages.LOGIN,
				ControllerConstants.Pages.LOGIN, new LoginForm());

		setUpPage(modelAndView, ControllerConstants.Pages.Titles.LOGIN);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView loginPost(@Valid LoginForm loginForm,
			BindingResult bindingResults, SessionStatus status,
			HttpServletRequest request) {
		ModelAndView modelAndView = null;
		boolean hasErrors = bindingResults.hasErrors();

		if (!hasErrors) {
			UserDto user = userFacade.checkUserCredentials(
					loginForm.getEmail(), loginForm.getPassword());

			if (user != null) {
				status.setComplete();
				request.getSession().setAttribute(
						ControllerConstants.GeneralConstants.LOGGEDIN_USER,
						user);
			} else {
				hasErrors = true;
			}
		}

		if (hasErrors) {
			modelAndView = new ModelAndView(ControllerConstants.Pages.LOGIN,
					ControllerConstants.Pages.LOGIN, loginForm);
		} else {
			modelAndView = new ModelAndView(REDIRECT_PREFIX
					+ ControllerConstants.Mappings.DASHBOARD);
		}

		setupHomeLink(request, hasErrors);
		return modelAndView;
	}

	private void setupHomeLink(HttpServletRequest request, boolean hasErrors) {
		if (hasErrors) {
			request.getSession().setAttribute(HOME_LINK,
					APPLICATION_ROOT + ControllerConstants.Mappings.HOMEPAGE);
		} else {
			request.getSession().setAttribute(HOME_LINK,
					APPLICATION_ROOT + ControllerConstants.Mappings.DASHBOARD);
		}
	}
}
