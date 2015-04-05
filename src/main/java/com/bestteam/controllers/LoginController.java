package com.bestteam.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bestteam.controllers.base.WebLearnerController;
import com.bestteam.controllers.forms.LoginForm;
import com.bestteam.controllers.utils.ControllerConstants;
import com.bestteam.domain.User;
import com.bestteam.services.user.UserService;

@Controller
@RequestMapping(ControllerConstants.Views.LOGIN)
public class LoginController extends WebLearnerController {

	private static final String LOGGEDIN_USER = "LOGGEDIN_USER";
	private static final String HOME_LINK = "homeLink";
	@Autowired
	private UserService userService;

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
		if (bindingResults.hasErrors()) {
			request.getSession().setAttribute(HOME_LINK,
					APPLICATION_ROOT + ControllerConstants.Views.HOMEPAGE);
			modelAndView = new ModelAndView(ControllerConstants.Pages.LOGIN,
					ControllerConstants.Pages.LOGIN, loginForm);
		} else {
			User user = new User();
			user.setEmail(loginForm.getEmail());
			user.setPassword(loginForm.getPassword());

			status.setComplete();

			request.getSession().setAttribute(HOME_LINK,
					APPLICATION_ROOT + ControllerConstants.Views.DASHBOARD);
			request.getSession().setAttribute(LOGGEDIN_USER, user);

			modelAndView = new ModelAndView(REDIRECT_PREFIX
					+ ControllerConstants.Views.DASHBOARD);
		}

		return modelAndView;
	}
}
