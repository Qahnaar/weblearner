package com.bestteam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bestteam.controller.utils.ControllerConstants;
import com.bestteam.converter.webinar.WebinarConverter;
import com.bestteam.dto.PresentationDto;
import com.bestteam.dto.WebinarDto;
import com.bestteam.facade.presentation.PresentationFacade;
import com.bestteam.facade.user.UserFacade;
import com.bestteam.facade.webinar.WebinarFacade;

@Controller
@RequestMapping(value = ControllerConstants.Mappings.PRESENTATION)
public class PresentationController {

	@Autowired
	private PresentationFacade presentationFacade;

	@Autowired
	private WebinarFacade webinarFacade;

	@Autowired
	private UserFacade userFacade;

	@Autowired
	private WebinarConverter webinarConverter;

	@RequestMapping(value = ControllerConstants.Mappings.UPLOAD_PRESENTATION, method = RequestMethod.POST)
	public @ResponseBody PresentationDto onSubmit(@PathVariable long webinarId,
			MultipartFile file) throws Exception {
		PresentationDto presentation = presentationFacade.saveSlides(webinarId,
				file);

		return presentation;
	}

	@RequestMapping(value = ControllerConstants.Mappings.PRESENTATIONS_WEBINAR, method = RequestMethod.GET)
	public @ResponseBody WebinarDto getPresentationsForWebinar(
			@PathVariable long webinarId) throws Exception {
		WebinarDto webinar = webinarFacade.get(webinarId);
		webinar.setLector(userFacade.getLectorForWebinar(webinarId));

		return webinar;
	}

	@RequestMapping(value = ControllerConstants.Mappings.PRESENTATION_SLIDE, method = RequestMethod.GET)
	@ResponseBody
	public String getSlideForPresentation(@PathVariable String webinarId,
			@PathVariable String presentationName, @PathVariable String slide)
			throws Exception {

		String encodedImage = presentationFacade.getBase64Slide(webinarId,
				presentationName, slide);

		return encodedImage;
	}
}
